package cds.gen;

import com.sap.cds.CdsData;
import com.sap.cds.ql.CdsName;
import java.lang.String;
import java.time.Instant;

@CdsName("managed")
public interface Managed extends CdsData {
  String CREATED_AT = "createdAt";

  String CREATED_BY = "createdBy";

  String MODIFIED_AT = "modifiedAt";

  String MODIFIED_BY = "modifiedBy";

  Instant getCreatedAt();

  void setCreatedAt(Instant createdAt);

  String getCreatedBy();

  void setCreatedBy(String createdBy);

  Instant getModifiedAt();

  void setModifiedAt(Instant modifiedAt);

  String getModifiedBy();

  void setModifiedBy(String modifiedBy);
}
