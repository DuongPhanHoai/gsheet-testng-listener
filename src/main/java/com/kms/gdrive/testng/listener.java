package com.kms.gdrive.testng;

import com.kms.gdrive.sheet.Report;
import com.kms.gdrive.sheet.Sheet;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class listener extends TestListenerAdapter {

  @Override
  public void onStart(ITestContext testContext) {
    System.out.println(">>>>>> START OF THE CONFIGURATION FROM GSHEET REPORT >>>>>>");
    String confDir = getAttributeFromSuite(testContext, "gsheet.confDir", "gconf");
    System.out.println(">>>>>> confDir >>>>>> " + confDir);
    Sheet.setCredentialDir(confDir, null);

    String sheetID = getAttributeFromSuite(testContext, "gsheet.sheetID", "1eaAz6HwGiZxJjpTIgasOzVegRFK2UnDUC2H6r0-SI2Q");
    String sheetName = getAttributeFromSuite(testContext, "gsheet.sheetName", "TestResult");
    System.out.println(">>>>>> sheetID >>>>>> " + sheetID);
    System.out.println(">>>>>> sheetName >>>>>> " + sheetName);
    Report.createNewResultCol(sheetName, sheetID);

    super.onStart(testContext);
  }

  @Override
  public void onTestFailure(ITestResult tr) {
    System.out.println(">>>>>>>>>>>>>>>>>>>>>>>> " + tr.getName() + " Failed");
    String sheetID = getAttributeFromSuite(tr.getTestContext(), "gsheet.sheetID", "1eaAz6HwGiZxJjpTIgasOzVegRFK2UnDUC2H6r0-SI2Q");
    String sheetName = getAttributeFromSuite(tr.getTestContext(), "gsheet.sheetName", "TestResult");
    Report.updateTestResultInExistingResult(tr.getName(), "Failed", sheetName, sheetID);
  }
 
  @Override
  public void onTestSkipped(ITestResult tr) {
    System.out.println(">>>>>>>>>>>>>>>>>>>>>>>> " + tr.getName() + " SKIP");
    String sheetID = getAttributeFromSuite(tr.getTestContext(), "gsheet.sheetID", "1eaAz6HwGiZxJjpTIgasOzVegRFK2UnDUC2H6r0-SI2Q");
    String sheetName = getAttributeFromSuite(tr.getTestContext(), "gsheet.sheetName", "TestResult");
    Report.updateTestResultInExistingResult(tr.getName(), "SKIP", sheetName, sheetID);
  }
 
  @Override
  public void onTestSuccess(ITestResult tr) {
    System.out.println(">>>>>>>>>>>>>>>>>>>>>>>> " + tr.getName() + " Passed");
    String sheetID = getAttributeFromSuite(tr.getTestContext(), "gsheet.sheetID", "1eaAz6HwGiZxJjpTIgasOzVegRFK2UnDUC2H6r0-SI2Q");
    String sheetName = getAttributeFromSuite(tr.getTestContext(), "gsheet.sheetName", "TestResult");
    Report.updateTestResultInExistingResult(tr.getName(), "Passed", sheetName, sheetID);
  }

  static String getAttributeFromSuite (ITestContext testContext, String attName, String defaultValue) {
    String strResult = defaultValue;
    String strTemp = testContext.getSuite().getParameter(attName);
    if (strTemp != null && strTemp.length() > 0)
      strResult = strTemp;
    return strResult;
  }
}