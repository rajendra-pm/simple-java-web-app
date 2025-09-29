# simple-java-web-app
# 🚀 CI/CD Pipeline with GitHub Actions, Docker, and AWS EC2 (Using SSH Key)

This project demonstrates how to set up a **CI/CD pipeline** using **GitHub Actions** to build, test, containerize, and deploy a **Java application** into an **AWS EC2 instance** with Docker.  
We are using **SSH Key (`Raja.pem`)** for authentication with the EC2 server.

---

## 📌 Workflow Overview

1. **Code Commit** → Push changes to GitHub.
2. **GitHub Actions** workflow triggers automatically.
3. **Build Stage** → Compile Java code and run tests.
4. **Docker Build & Push** → Build Docker image and push to Docker Hub.
5. **Deploy Stage** → Connect to EC2 via SSH (using PEM key) and run the container.

---

## 🛠️ Prerequisites

- **AWS EC2 Instance** (Ubuntu)
  - Security group must allow inbound on **22 (SSH)** and **8080 (App)**.
  - Docker installed on EC2:
    ```bash
    sudo apt-get update -y
    sudo apt-get install -y docker.io
    sudo systemctl start docker
    sudo systemctl enable docker
    sudo usermod -aG docker ubuntu
    newgrp docker
    docker --version
    ```
- **Docker Hub Account** (for storing Docker images).
- **GitHub Repository** with this project code.
- **PEM Key (Raja.pem)** to SSH into your EC2.

---

## 🔑 GitHub Secrets Setup

Add the following secrets in your GitHub repo:

- `DOCKER_HUB_USERNAME` → Your Docker Hub username  
- `DOCKER_HUB_ACCESS_TOKEN` → Your Docker Hub access token/password  
- `EC2_HOST` → Your EC2 Public IP (e.g., `35.xxx.xxx.xxx`)  
- `EC2_USER` → Usually `ubuntu` (default for Ubuntu EC2 AMI)  
- `SSH_KEY` → Copy the **full content of Raja.pem** file and paste it here  

> ⚠️ No need for Base64 — just paste the PEM key contents directly into `SSH_KEY`.
