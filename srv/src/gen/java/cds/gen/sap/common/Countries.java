package cds.gen.sap.common;

import com.sap.cds.CdsData;
import com.sap.cds.Struct;
import com.sap.cds.ql.CdsName;
import java.lang.String;
import java.util.List;
import java.util.Map;

@CdsName("sap.common.Countries")
public interface Countries extends CdsData {
  String DESCR = "descr";

  String CODE = "code";

  String TEXTS = "texts";

  String NAME = "name";

  String LOCALIZED = "localized";

  String getDescr();

  void setDescr(String descr);

  String getCode();

  void setCode(String code);

  List<CountriesTexts> getTexts();

  void setTexts(List<? extends Map<String, ?>> texts);

  String getName();

  void setName(String name);

  CountriesTexts getLocalized();

  void setLocalized(Map<String, ?> localized);

  static Countries create() {
    return Struct.create(Countries.class);
  }
}
