#!/bin/bash
# Start DESM Environment

echo "Let's start iHome environment..."
java -jar target/module-ihome-0.1-jar-with-dependencies.jar "/Users/heisenberg/Box Sync/connectx/code/sebastianstraube/connectx/core/config_server.json" "/Users/heisenberg/Box Sync/connectx/code/sebastianstraube/connectx/module-ihome/config_automation.json"
