# MeshTalk — BLE Offline Multi-Hop Chat (Android Java)

## Overview
Peer-to-peer offline chat using Bluetooth Low Energy.
Features: nickname, neighbor list, Ming (RTT), multi-hop routing, local storage.

## Tech stack
- Android (Java)
- Room DB
- Bluetooth LE (advertise, scan, GATT)
- Gson for JSON



## How to run (dev)
1. Clone repo
2. Open in Android Studio
3. Build & run on devices (two+ for testing)

## Key features (MVP)
- BLE advertising/scanning w/ nickname
- Chat and multi-hop forwarding
- Ming (RTT) to measure latency
- Local storage via Room DB
