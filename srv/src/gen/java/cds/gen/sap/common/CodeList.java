package cds.gen.sap.common;

import com.sap.cds.CdsData;
import com.sap.cds.ql.CdsName;
import java.lang.String;

@CdsName("sap.common.CodeList")
public interface CodeList extends CdsData {
  String DESCR = "descr";

  String NAME = "name";

  String getDescr();

  void setDescr(String descr);

  String getName();

  void setName(String name);
}
