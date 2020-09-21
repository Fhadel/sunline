import java.text.SimpleDateFormat

import internal.GlobalVariable

String oldDateString = GlobalVariable.Date;
String newDateString;
SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
Date d = sdf.parse(oldDateString);
sdf.applyPattern("ddMMyy");
newDateString = sdf.format(d);
println newDateString




String dateisStr = GlobalVariable.Date
println dateisStr.replaceAll("/", "")