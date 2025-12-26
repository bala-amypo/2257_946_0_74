# Create the directory
mkdir -p src/test/java/com/example/demo/

# Create the file
cat <<EOF > src/test/java/com/example/demo/TestResultListener.java
package com.example.demo;
import org.testng.ITestListener;
import org.testng.ITestResult;
public class TestResultListener implements ITestListener {
    public void onTestSuccess(ITestResult result) { System.out.println("PASSED: " + result.getName()); }
    public void onTestFailure(ITestResult result) { System.out.println("FAILED: " + result.getName()); }
}
EOF