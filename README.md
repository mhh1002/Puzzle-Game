# 🧩 Puzzle Game

A Java Swing-based **image tile puzzle game** with a structured GUI for login and registration. This project features a playable sliding puzzle and placeholder login/signup interfaces, ideal for educational purposes or UI prototyping.

---

## 🔍 Features

- 🧩 **Sliding Puzzle Game**  
  Rearrange shuffled image tiles to restore the full picture.

- 👤 **Login & Registration UI (Frontend Only)**  
  Visually designed login and signup windows using Swing, but **no actual authentication or data persistence yet**.

- 🎨 **Custom Graphics**  
  Includes button icons, UI labels (e.g., "登录按钮.png"), and tile images stored in a structured directory.

- 📁 **Organized Image Resources**  
  Puzzle images are placed under folders like `image/animal/animal3/1.png`, `image/login/`, etc.

---

## 📁 Project Structure

Puzzle-Game/
├── src/
│ ├── GameMainFrame.java # Core puzzle logic and game UI
│ ├── LoginFrame.java # Login screen (UI only)
│ └── SignUp.java # Registration screen (UI only)
│
├── image/ # Contains UI and puzzle images
│ ├── login/ # e.g., 登录按钮.png
│ ├── signup/
│ └── animal/
│ └── animal3/ # 1.png, 2.png, etc.
│
├── PuzzleGame.jar # Optional JAR build (if available)
└── README.md

---

## ⚙️ Current Implementation Status

| Module       | Status     | Notes                                               |
|--------------|------------|-----------------------------------------------------|
| Puzzle Game  | ✅ Complete | Fully functional puzzle mechanics                   |
| Login Screen | ⚠️ UI only | No actual login validation or user data handling    |
| Sign-Up Form | ⚠️ UI only | No user data saved or used after input              |

---

## ▶️ How to Run

### 💻 Run from Source

1. Clone the repository:
   ```bash
   git clone https://github.com/mhh1002/Puzzle-Game.git
   cd Puzzle-Game

---

### ✅ Next Steps

1. Copy this content and save it as a `README.md` file in your project root.
2. Push it to your GitHub repository:

```bash
git add README.md
git commit -m "Add complete project README in English"
git push origin master
