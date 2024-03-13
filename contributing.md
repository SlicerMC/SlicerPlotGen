# Contributing to Slicer

We welcome any to contribute to the Slicer Plot Gen. If you wish to do so, please make sure you follow the guidelines set below. There is a high chance we will not accept a pull request if it does not follow our guidelines.
### IDE:
* Our IDE of choice is IntelliJ.
* If you use another IDE, do not include any of the project settings with your commits.
### Formating
* All indents are TAB characters, not spaces.
* Braces for functions/methods/scopes start on one line and end on a new-line (See Code Example A).
* A scope containing only one statement should be surrounded by braces (See Code Example A).
* Ternary statements should be used but only where NEEDED.
* Inside a *switch* the *case* and *break* should be on new lines (See Code Example B).
* Normal String concatenation and the StringBuilder class are favored over String#format().
* No trailing whitespace.
* Make sure any changes you submit are tested properly!
* Your commit messages should be descriptive yet short.
### Misc:
* Changes to project files for personal preference should not be committed unless vital to the running of the project (library includes etc.).
* Please make sure there is an issue open in the correct project regarding the enhancement/bug-fix you are working on.


#### Code Example A:
```java
public class Example {
  public boolean canLockBlock(IBlock block) {
    for (Item item : LockedObjectHandler.lockableItems) {
      if (block.is(item)) {
        return true;
      }
    }
  return false;
  }
}
```

#### Code Example B:
```java
public class Example {
  public void Example() {
    switch (myValue) {
      case 0:
        foo();
        break;
      case 1:
        bar();
        baz();
        break;
    }		
  }
}
```
