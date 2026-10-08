# KitchenThreads — Multithreading with a Restaurant Kitchen

A plain-Java simulation of a kitchen.

- There's a **menu** of dishes, each with a cooking time.
- A list of **orders** comes in.
- **Chefs** (threads) cook them.

With **1 chef** everything is cooked one dish after another. With **more chefs**
the orders are split between them, so the kitchen finishes sooner.

Only basic threading is used: `Runnable`, `Thread`, `start()`, `sleep()`, `join()`
and `synchronized`. There's **no ExecutorService**.

---

## Menu

| Dish    | Cooking time |
|---------|--------------|
| Idli    | 2 s |
| Dosa    | 3 s |
| Vada    | 1 s |
| Pongal  | 3 s |
| Parotta | 4 s |
| Biryani | 10 s |

To change the menu, edit `Menu.java`. To change the orders, edit the list in `App.java`.

---

## Files

| File | What it is |
|------|------------|
| `Menu.java` | `Map<String, Integer>`: dish → seconds |
| `Order.java` | one order (id + dish) |
| `OrderQueue.java` | the **shared** list of pending orders. Its methods are `synchronized` |
| `Chef.java` | `implements Runnable`. It loops: take an order → `sleep` (cook) → repeat |
| `Kitchen.java` | creates N chefs + N threads, `start()`s them, `join()`s them, prints a summary |
| `App.java` | `main`: the menu, the order list, and how many chefs to use |

---

## How to run

Run these from the **`Java`** folder, the parent of `KitchenThreads`, because the package name is `KitchenThreads`.

Compile:

```bash
javac -d bin KitchenThreads/*.java
```

Run with 1 chef, then 3 chefs, so you can compare:

```bash
java -cp bin KitchenThreads.App
```

Run with any number of chefs, for example 2:

```bash
java -cp bin KitchenThreads.App 2
```

You can also open `App.java` in VS Code and click **Run**.

---

## Sample output (real run)

**1 chef (synchronous, one after another):**
```
[  0.0s] Chef-1 started  #1 Idli (2s)
[  2.0s] Chef-1 finished #1 Idli (2s)
[  2.0s] Chef-1 started  #2 Biryani (10s)
[ 12.0s] Chef-1 finished #2 Biryani (10s)
...
Total time with 1 chef(s): 39.1s      <- 2+10+3+1+3+3+4+2+10+1 = 39
```

**3 chefs (parallel, work is split):**
```
[  0.0s] Chef-1 started  #1 Idli (2s)
[  0.0s] Chef-3 started  #3 Dosa (3s)
[  0.0s] Chef-2 started  #2 Biryani (10s)
[  2.0s] Chef-1 finished #1 Idli (2s)
[  2.0s] Chef-1 started  #4 Vada (1s)      <- free chef immediately grabs the next order
...
Chef-1   cooked 5 dish(es), busy for 18s
Chef-2   cooked 2 dish(es), busy for 11s
Chef-3   cooked 3 dish(es), busy for 10s
Orders completed: 10/10
Total time with 3 chef(s): 18.0s
```

---

## How it works

```
                 ┌──────────────── OrderQueue (shared, synchronized) ───────────────┐
                 │  #1 Idli  #2 Biryani  #3 Dosa  #4 Vada  ...  #10 Vada            │
                 └───────▲──────────────────▲──────────────────▲────────────────────┘
                         │ takeNext()       │ takeNext()       │ takeNext()
                    ┌────┴────┐        ┌────┴────┐        ┌────┴────┐
                    │ Chef-1  │        │ Chef-2  │        │ Chef-3  │   <- each is its own Thread
                    │ sleep() │        │ sleep() │        │ sleep() │      (sleep = cooking)
                    └─────────┘        └─────────┘        └─────────┘
main thread: start() all chefs ──► join() waits for all ──► prints summary
```

1. **`Kitchen.run`** creates one `Chef` (a `Runnable`) per chef and wraps each in a `new Thread(chef)`.
2. **`start()`** makes every chef thread begin `run()` at the same time.
3. Each chef keeps calling `queue.takeNext()`. A chef that finishes early just grabs the next order, so the work is **split dynamically**, not pre-assigned.
4. `Thread.sleep(seconds * 1000)` stands in for cooking.
5. When `takeNext()` returns `null`, the queue is empty and the chef's thread ends.
6. **`join()`**: the main thread waits until all chef threads are done before printing the total time.

### Why `synchronized`?

All chefs share **one** `OrderQueue`. Without `synchronized` on `takeNext()`, two chefs could
run `pending.removeFirst()` at the same moment and both cook the same order, or corrupt the
`LinkedList`. `synchronized` lets only **one thread at a time** into the method. The others wait
for their turn, which takes a few microseconds.

The same goes for `markDone()`. `completedCount++` is really *read → add 1 → write*, so two threads
can overwrite each other's update unless it's synchronized.

`Kitchen.log()` is synchronized too, so output lines from different chefs don't get mixed together.

### Why 3 chefs took 18s and not 13s (39 ÷ 3)

Chefs take orders **in order**. The second Biryani (10s) was taken late, at 8s, by Chef-1,
so the kitchen had to wait for it while the other chefs were already free at 10–11s.
**Total time = when the last chef finishes.** Try moving both Biryanis to the
front of the order list and run it again. Starting the long dishes first balances the load better.

### Things to try

- Pass `1`, `2`, `5`, then `10` chefs. Past a point, extra chefs don't help, because one Biryani alone takes 10s.
- Remove `synchronized` from `takeNext()` and `markDone()`, then run with many chefs and short dishes. You may see duplicate or skipped orders, or a wrong count. That's a **race condition**.
- Add a new dish to `Menu.java` and to the order list.
