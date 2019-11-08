Update test suite such as following sample which:
 - gsheet.confDir : google sheet report configuration dir
 - gsheet.sheetID : google sheet id which get from URL (Ex: 'abcTheGoogleSheetId' from the URL 'https://docs.google.com/spreadsheets/d/abcTheGoogleSheetId/edit#gid=0')
 - gsheet.sheetName : the sheet Name to update report

Further information will be update later

<?xml version="1.0" encoding="UTF-8"?>
<suite name="TestNgMavenExampleSuite" parallel="false">
    <parameter name="gsheet.confDir"  value="gconf"/>
    <parameter name="gsheet.sheetID"  value="1eaAz6HwGiZxJjpTIgasOzVegRFK2UnDUC2H6r0-SI2Q"/>
    <parameter name="gsheet.sheetName"  value="TestResult"/>

  <listeners>
    <listener class-name="com.mycompany.app.myListener" />
  </listeners>



  <test name="TestNgMavenTest">
    <classes>
      <class name="com.mycompany.app.myTest"/>
      <class name="com.mycompany.app.myTest2"/>
    </classes>
  </test>

</suite>