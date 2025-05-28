# Puzzle Game 🧩

A simple Java Swing-based **Puzzle Game** with a basic GUI structure for login and registration. This project showcases how to build a puzzle game UI with placeholder login/register pages, ideal as a learning or prototype project.

---

## 🔍 Features

- 🧩 **Puzzle Gameplay**: Rearrange shuffled image tiles to complete the puzzle.
- 🖼️ **Custom Image Assets**: Includes themed puzzle images and button icons.
- 👤 **Login/Sign-Up GUI** *(UI only)*: Screens for login and registration are implemented visually, but **no backend validation or persistence logic** is included yet.

---

## 📁 Project Structure
Project/
├── src/
│ ├── GameMainFrame.java # Puzzle game logic and GUI
│ ├── LoginFrame.java # Login window (UI only)
│ └── SignUp.java # Sign-up window (UI only)
│
├── image/ # Contains UI and puzzle images
│ ├── login/ # e.g., 登录按钮.png
│ ├── signup/
│ └── animal/
│ └── animal3/ # 1.png, 2.png, ..., for the puzzle
│
├── PuzzleGame.jar # Built executable JAR (if available)
└── README.md # This file

---

## ⚙️ Current Functionality

| Module       | Status      | Description                                      |
|--------------|-------------|--------------------------------------------------|
| Puzzle Game  | ✅ 完成     | 拖动拼图完成图像重建                             |
| Login Frame  | ⚠️ UI界面   | 无实际用户验证逻辑                              |
| Sign-Up Form | ⚠️ UI界面   | 输入信息不会保存，也不会传递                    |

---

## ▶️ How to Run

### 💻 From Source (IntelliJ or any Java IDE)

1. 克隆项目：
   ```bash
   git clone https://github.com/mhh1002/Puzzle-Game.git
   cd Puzzle-Game


---

### ✅ 如何使用：

1. 将上面这段内容复制为 `README.md` 文件。
2. 放在你的项目根目录（即包含 `.git` 的那个目录）。
3. 然后执行：

```bash
git add README.md
git commit -m "Add full project README"
git push origin master

