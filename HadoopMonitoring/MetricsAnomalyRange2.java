// ORM class for table 'MetricsAnomalyRange2'
// WARNING: This class is AUTO-GENERATED. Modify at your own risk.
//
// Debug information:
// Generated date: Tue Aug 28 12:00:13 UTC 2018
// For connector: org.apache.sqoop.manager.MySQLManager
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapred.lib.db.DBWritable;
import org.apache.sqoop.lib.JdbcWritableBridge;
import org.apache.sqoop.lib.DelimiterSet;
import org.apache.sqoop.lib.FieldFormatter;
import org.apache.sqoop.lib.RecordParser;
import org.apache.sqoop.lib.BooleanParser;
import org.apache.sqoop.lib.BlobRef;
import org.apache.sqoop.lib.ClobRef;
import org.apache.sqoop.lib.LargeObjectLoader;
import org.apache.sqoop.lib.SqoopRecord;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class MetricsAnomalyRange2 extends SqoopRecord  implements DBWritable, Writable {
  private final int PROTOCOL_VERSION = 3;
  public int getClassFormatVersion() { return PROTOCOL_VERSION; }
  public static interface FieldSetterCommand {    void setField(Object value);  }  protected ResultSet __cur_result_set;
  private Map<String, FieldSetterCommand> setters = new HashMap<String, FieldSetterCommand>();
  private void init0() {
    setters.put("metricsName", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        MetricsAnomalyRange2.this.metricsName = (String)value;
      }
    });
    setters.put("host", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        MetricsAnomalyRange2.this.host = (String)value;
      }
    });
    setters.put("lowerLimit", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        MetricsAnomalyRange2.this.lowerLimit = (Double)value;
      }
    });
    setters.put("upperLimit", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        MetricsAnomalyRange2.this.upperLimit = (Double)value;
      }
    });
    setters.put("createdTime", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        MetricsAnomalyRange2.this.createdTime = (java.sql.Timestamp)value;
      }
    });
  }
  public MetricsAnomalyRange2() {
    init0();
  }
  private String metricsName;
  public String get_metricsName() {
    return metricsName;
  }
  public void set_metricsName(String metricsName) {
    this.metricsName = metricsName;
  }
  public MetricsAnomalyRange2 with_metricsName(String metricsName) {
    this.metricsName = metricsName;
    return this;
  }
  private String host;
  public String get_host() {
    return host;
  }
  public void set_host(String host) {
    this.host = host;
  }
  public MetricsAnomalyRange2 with_host(String host) {
    this.host = host;
    return this;
  }
  private Double lowerLimit;
  public Double get_lowerLimit() {
    return lowerLimit;
  }
  public void set_lowerLimit(Double lowerLimit) {
    this.lowerLimit = lowerLimit;
  }
  public MetricsAnomalyRange2 with_lowerLimit(Double lowerLimit) {
    this.lowerLimit = lowerLimit;
    return this;
  }
  private Double upperLimit;
  public Double get_upperLimit() {
    return upperLimit;
  }
  public void set_upperLimit(Double upperLimit) {
    this.upperLimit = upperLimit;
  }
  public MetricsAnomalyRange2 with_upperLimit(Double upperLimit) {
    this.upperLimit = upperLimit;
    return this;
  }
  private java.sql.Timestamp createdTime;
  public java.sql.Timestamp get_createdTime() {
    return createdTime;
  }
  public void set_createdTime(java.sql.Timestamp createdTime) {
    this.createdTime = createdTime;
  }
  public MetricsAnomalyRange2 with_createdTime(java.sql.Timestamp createdTime) {
    this.createdTime = createdTime;
    return this;
  }
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof MetricsAnomalyRange2)) {
      return false;
    }
    MetricsAnomalyRange2 that = (MetricsAnomalyRange2) o;
    boolean equal = true;
    equal = equal && (this.metricsName == null ? that.metricsName == null : this.metricsName.equals(that.metricsName));
    equal = equal && (this.host == null ? that.host == null : this.host.equals(that.host));
    equal = equal && (this.lowerLimit == null ? that.lowerLimit == null : this.lowerLimit.equals(that.lowerLimit));
    equal = equal && (this.upperLimit == null ? that.upperLimit == null : this.upperLimit.equals(that.upperLimit));
    equal = equal && (this.createdTime == null ? that.createdTime == null : this.createdTime.equals(that.createdTime));
    return equal;
  }
  public boolean equals0(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof MetricsAnomalyRange2)) {
      return false;
    }
    MetricsAnomalyRange2 that = (MetricsAnomalyRange2) o;
    boolean equal = true;
    equal = equal && (this.metricsName == null ? that.metricsName == null : this.metricsName.equals(that.metricsName));
    equal = equal && (this.host == null ? that.host == null : this.host.equals(that.host));
    equal = equal && (this.lowerLimit == null ? that.lowerLimit == null : this.lowerLimit.equals(that.lowerLimit));
    equal = equal && (this.upperLimit == null ? that.upperLimit == null : this.upperLimit.equals(that.upperLimit));
    equal = equal && (this.createdTime == null ? that.createdTime == null : this.createdTime.equals(that.createdTime));
    return equal;
  }
  public void readFields(ResultSet __dbResults) throws SQLException {
    this.__cur_result_set = __dbResults;
    this.metricsName = JdbcWritableBridge.readString(1, __dbResults);
    this.host = JdbcWritableBridge.readString(2, __dbResults);
    this.lowerLimit = JdbcWritableBridge.readDouble(3, __dbResults);
    this.upperLimit = JdbcWritableBridge.readDouble(4, __dbResults);
    this.createdTime = JdbcWritableBridge.readTimestamp(5, __dbResults);
  }
  public void readFields0(ResultSet __dbResults) throws SQLException {
    this.metricsName = JdbcWritableBridge.readString(1, __dbResults);
    this.host = JdbcWritableBridge.readString(2, __dbResults);
    this.lowerLimit = JdbcWritableBridge.readDouble(3, __dbResults);
    this.upperLimit = JdbcWritableBridge.readDouble(4, __dbResults);
    this.createdTime = JdbcWritableBridge.readTimestamp(5, __dbResults);
  }
  public void loadLargeObjects(LargeObjectLoader __loader)
      throws SQLException, IOException, InterruptedException {
  }
  public void loadLargeObjects0(LargeObjectLoader __loader)
      throws SQLException, IOException, InterruptedException {
  }
  public void write(PreparedStatement __dbStmt) throws SQLException {
    write(__dbStmt, 0);
  }

  public int write(PreparedStatement __dbStmt, int __off) throws SQLException {
    JdbcWritableBridge.writeString(metricsName, 1 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(host, 2 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeDouble(lowerLimit, 3 + __off, 8, __dbStmt);
    JdbcWritableBridge.writeDouble(upperLimit, 4 + __off, 8, __dbStmt);
    JdbcWritableBridge.writeTimestamp(createdTime, 5 + __off, 93, __dbStmt);
    return 5;
  }
  public void write0(PreparedStatement __dbStmt, int __off) throws SQLException {
    JdbcWritableBridge.writeString(metricsName, 1 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(host, 2 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeDouble(lowerLimit, 3 + __off, 8, __dbStmt);
    JdbcWritableBridge.writeDouble(upperLimit, 4 + __off, 8, __dbStmt);
    JdbcWritableBridge.writeTimestamp(createdTime, 5 + __off, 93, __dbStmt);
  }
  public void readFields(DataInput __dataIn) throws IOException {
this.readFields0(__dataIn);  }
  public void readFields0(DataInput __dataIn) throws IOException {
    if (__dataIn.readBoolean()) { 
        this.metricsName = null;
    } else {
    this.metricsName = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.host = null;
    } else {
    this.host = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.lowerLimit = null;
    } else {
    this.lowerLimit = Double.valueOf(__dataIn.readDouble());
    }
    if (__dataIn.readBoolean()) { 
        this.upperLimit = null;
    } else {
    this.upperLimit = Double.valueOf(__dataIn.readDouble());
    }
    if (__dataIn.readBoolean()) { 
        this.createdTime = null;
    } else {
    this.createdTime = new Timestamp(__dataIn.readLong());
    this.createdTime.setNanos(__dataIn.readInt());
    }
  }
  public void write(DataOutput __dataOut) throws IOException {
    if (null == this.metricsName) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, metricsName);
    }
    if (null == this.host) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, host);
    }
    if (null == this.lowerLimit) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.lowerLimit);
    }
    if (null == this.upperLimit) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.upperLimit);
    }
    if (null == this.createdTime) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.createdTime.getTime());
    __dataOut.writeInt(this.createdTime.getNanos());
    }
  }
  public void write0(DataOutput __dataOut) throws IOException {
    if (null == this.metricsName) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, metricsName);
    }
    if (null == this.host) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, host);
    }
    if (null == this.lowerLimit) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.lowerLimit);
    }
    if (null == this.upperLimit) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.upperLimit);
    }
    if (null == this.createdTime) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.createdTime.getTime());
    __dataOut.writeInt(this.createdTime.getNanos());
    }
  }
  private static final DelimiterSet __outputDelimiters = new DelimiterSet((char) 44, (char) 10, (char) 0, (char) 0, false);
  public String toString() {
    return toString(__outputDelimiters, true);
  }
  public String toString(DelimiterSet delimiters) {
    return toString(delimiters, true);
  }
  public String toString(boolean useRecordDelim) {
    return toString(__outputDelimiters, useRecordDelim);
  }
  public String toString(DelimiterSet delimiters, boolean useRecordDelim) {
    StringBuilder __sb = new StringBuilder();
    char fieldDelim = delimiters.getFieldsTerminatedBy();
    __sb.append(FieldFormatter.escapeAndEnclose(metricsName==null?"null":metricsName, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(host==null?"null":host, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(lowerLimit==null?"null":"" + lowerLimit, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(upperLimit==null?"null":"" + upperLimit, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(createdTime==null?"null":"" + createdTime, delimiters));
    if (useRecordDelim) {
      __sb.append(delimiters.getLinesTerminatedBy());
    }
    return __sb.toString();
  }
  public void toString0(DelimiterSet delimiters, StringBuilder __sb, char fieldDelim) {
    __sb.append(FieldFormatter.escapeAndEnclose(metricsName==null?"null":metricsName, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(host==null?"null":host, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(lowerLimit==null?"null":"" + lowerLimit, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(upperLimit==null?"null":"" + upperLimit, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(createdTime==null?"null":"" + createdTime, delimiters));
  }
  private static final DelimiterSet __inputDelimiters = new DelimiterSet((char) 44, (char) 10, (char) 0, (char) 0, false);
  private RecordParser __parser;
  public void parse(Text __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(CharSequence __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(byte [] __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(char [] __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(ByteBuffer __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(CharBuffer __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  private void __loadFromFields(List<String> fields) {
    Iterator<String> __it = fields.listIterator();
    String __cur_str = null;
    try {
    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.metricsName = null; } else {
      this.metricsName = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.host = null; } else {
      this.host = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.lowerLimit = null; } else {
      this.lowerLimit = Double.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.upperLimit = null; } else {
      this.upperLimit = Double.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.createdTime = null; } else {
      this.createdTime = java.sql.Timestamp.valueOf(__cur_str);
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  private void __loadFromFields0(Iterator<String> __it) {
    String __cur_str = null;
    try {
    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.metricsName = null; } else {
      this.metricsName = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.host = null; } else {
      this.host = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.lowerLimit = null; } else {
      this.lowerLimit = Double.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.upperLimit = null; } else {
      this.upperLimit = Double.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.createdTime = null; } else {
      this.createdTime = java.sql.Timestamp.valueOf(__cur_str);
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  public Object clone() throws CloneNotSupportedException {
    MetricsAnomalyRange2 o = (MetricsAnomalyRange2) super.clone();
    o.createdTime = (o.createdTime != null) ? (java.sql.Timestamp) o.createdTime.clone() : null;
    return o;
  }

  public void clone0(MetricsAnomalyRange2 o) throws CloneNotSupportedException {
    o.createdTime = (o.createdTime != null) ? (java.sql.Timestamp) o.createdTime.clone() : null;
  }

  public Map<String, Object> getFieldMap() {
    Map<String, Object> __sqoop$field_map = new HashMap<String, Object>();
    __sqoop$field_map.put("metricsName", this.metricsName);
    __sqoop$field_map.put("host", this.host);
    __sqoop$field_map.put("lowerLimit", this.lowerLimit);
    __sqoop$field_map.put("upperLimit", this.upperLimit);
    __sqoop$field_map.put("createdTime", this.createdTime);
    return __sqoop$field_map;
  }

  public void getFieldMap0(Map<String, Object> __sqoop$field_map) {
    __sqoop$field_map.put("metricsName", this.metricsName);
    __sqoop$field_map.put("host", this.host);
    __sqoop$field_map.put("lowerLimit", this.lowerLimit);
    __sqoop$field_map.put("upperLimit", this.upperLimit);
    __sqoop$field_map.put("createdTime", this.createdTime);
  }

  public void setField(String __fieldName, Object __fieldVal) {
    if (!setters.containsKey(__fieldName)) {
      throw new RuntimeException("No such field:"+__fieldName);
    }
    setters.get(__fieldName).setField(__fieldVal);
  }

}
