#!/bin/bash
# Compiles the project with plain javac and (optionally) deploys it to Tomcat.
#
#   ./build.sh            -> compile only
#   ./build.sh deploy     -> compile + copy to $CATALINA_HOME/webapps/shop
#
# CATALINA_HOME must point to your Tomcat folder (it has bin/, lib/, webapps/ inside).

set -e
cd "$(dirname "$0")"

if [ -z "$CATALINA_HOME" ]; then
    echo "ERROR: CATALINA_HOME is not set. Example:"
    echo "  export CATALINA_HOME=\$HOME/apache-tomcat-10.1.x"
    exit 1
fi

SERVLET_JAR="$CATALINA_HOME/lib/servlet-api.jar"
OUT="webapp/WEB-INF/classes"

echo "==> Compiling sources into $OUT"
rm -rf "$OUT"
mkdir -p "$OUT"
javac -cp "$SERVLET_JAR:webapp/WEB-INF/lib/*" -d "$OUT" $(find src -name "*.java")

if [ "$1" == "deploy" ]; then
    echo "==> Deploying to $CATALINA_HOME/webapps/shop"
    rm -rf "$CATALINA_HOME/webapps/shop"
    cp -R webapp "$CATALINA_HOME/webapps/shop"
    echo "Done. Open http://localhost:8080/shop/ (Tomcat must be running)"
else
    echo "Done. Run './build.sh deploy' to copy it into Tomcat."
fi
