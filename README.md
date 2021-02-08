# Testing Exercise

## Building the project

### Pre-conditions:

1. Java 8 
2. Eclipse IDE
3. Browser Drivers [download link](https://github.com/mozilla/geckodriver/releases)

### Get Started

#### 1. Configure the driver path in the operating system

  ##### 1.1 Windows
  
- Having all the drivers in one folder
- Go to “Control Panel> System and Security> System”, click on “Advanced system settings”
- Click on the “Advanced” tab, click on “Environment Variables”
- Locate the “Path” in the “System variables” section
- With it selected, click on “Edit…”
 Attention: Do not delete the contents of the variable, just add the path to the folder with drivers at the beginning.
- Don't forget to put a ; (semicolon)o make a division with the other values that are already in the variable.
- Click the OK button for all windows that have been opened
 
##### 1.2 Linux
  
- Once you have downloaded, just add it to a file that is loaded by the operating system. I recommend the / etc / profile file, but it is important to know that the files may vary depending on the OS distribution you are using.
- Add, at the end of the file, a line that will inform the directory in question to the PATH of the operating system: ``` export PATH=$PATH:/PATH/OF/YOUR/FOLDER ```

##### 1.3 OSX
  
- Once you have downloaded, just add it to a file that is loaded by the operating system, for OSX, I recommend the /etc/paths file.
- Add, at the end of the file, the full path to the folder where you placed the drivers:``` /PATH/OF/YOUR/FOLDER```
    
#### 2. Clone
```
cd ~/workspace
```
```
git clone git@github.com:mirandastephane/testing-exercise.git
```
#### 3. Run Tests

    Run the tests from the JUnit run (src/main/java/TestForm/TestForm.java)

