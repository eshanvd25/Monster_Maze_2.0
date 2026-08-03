# GitHub SSH Setup

This guide explains how to connect a local computer to GitHub using SSH.

---

# Check if an SSH key already exists

Open a terminal.

Run:

```bash
ls ~/.ssh
```

Expected output:

```text
id_ed25519
id_ed25519.pub
known_hosts
...
```

If you already have:

```text
id_ed25519
id_ed25519.pub
```

then an SSH key already exists.

If not, create one.

---

# Create a new SSH key

Run:

```bash
ssh-keygen -t ed25519 -C "your-email@example.com"
```

---

## Choose where to save it

The terminal will ask:

```text
Enter file in which to save the key
```

If this is your first key:

Press **Enter**.

If you already have another key, give it a different name.

Example:

```text
/home/username/.ssh/github_personal
```

**Do not type**

```text
~/.ssh/github_personal
```

Some terminals do not expand `~` correctly here.

Use the full path instead.

---

## Enter a passphrase

You can:

- enter a password
- or press Enter twice for no password

---

# Verify the key exists

Run:

```bash
ls ~/.ssh
```

Expected output:

```text
github_personal
github_personal.pub
```

---

# Copy the public key

Run:

```bash
cat ~/.ssh/github_personal.pub
```

Expected output:

```text
ssh-ed25519 AAAA............. your-email@example.com
```

Copy the **entire line**.

---

# Add the key to GitHub

GitHub

↓

Settings

↓

SSH and GPG Keys

↓

New SSH Key

Paste the copied key.

Save.

---

# Start the SSH agent

Run:

```bash
eval "$(ssh-agent -s)"
```

Expected output:

```text
Agent pid ####
```

---

# Add your key

Run:

```bash
ssh-add ~/.ssh/github_personal
```

Expected output:

```text
Identity added:
```

---

# Test the connection

Run:

```bash
ssh -T git@github.com
```

The first time you may see:

```text
Are you sure you want to continue connecting?
```

Type:

```text
yes
```

Expected output:

```text
Hi USERNAME!
You've successfully authenticated...
```

---

# Change the repository to SSH

Check the current remote.

```bash
git remote -v
```

If it starts with

```text
https://
```

change it.

Run:

```bash
git remote set-url origin git@github.com:USERNAME/REPOSITORY.git
```

Example:

```bash
git remote set-url origin git@github.com:eshanvd25/Monster_Maze_2.0.git
```

Verify:

```bash
git remote -v
```

Expected output:

```text
git@github.com:USERNAME/REPOSITORY.git
```

---

# Push

Run:

```bash
git push
```

Expected output:

```text
Enumerating objects...

Writing objects...

Done.
```

No username or password should be requested.

---

# Common Problems

## Problem

```text
Password authentication is not supported.
```

### Solution

The repository is still using HTTPS.

Check:

```bash
git remote -v
```

If it starts with:

```text
https://
```

change it to SSH.

---

## Problem

```text
Saving key failed:
No such file or directory
```

### Solution

Do not use:

```text
~/.ssh/github_personal
```

Use the full path.

Example:

```text
/home/username/.ssh/github_personal
```

---

## Problem

```text
Key is invalid.
```

### Solution

Make sure you copied the **public** key.

Run:

```bash
cat ~/.ssh/github_personal.pub
```

Copy the entire output.

Do **not** copy the private key.

---

## Problem

```text
Permission denied (publickey)
```

### Solution

Start the SSH agent:

```bash
eval "$(ssh-agent -s)"
```

Then add the key:

```bash
ssh-add ~/.ssh/github_personal
```

Try again.

---

# Useful Commands

List SSH keys:

```bash
ls ~/.ssh
```

View public key:

```bash
cat ~/.ssh/github_personal.pub
```

Check repository remote:

```bash
git remote -v
```

Test GitHub connection:

```bash
ssh -T git@github.com
```

Push changes:

```bash
git push
```
