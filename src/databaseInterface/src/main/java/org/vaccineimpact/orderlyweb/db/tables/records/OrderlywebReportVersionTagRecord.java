/*
 * This file is generated by jOOQ.
 */
package org.vaccineimpact.orderlyweb.db.tables.records;


import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.UpdatableRecordImpl;
import org.vaccineimpact.orderlyweb.db.tables.OrderlywebReportVersionTag;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class OrderlywebReportVersionTagRecord extends UpdatableRecordImpl<OrderlywebReportVersionTagRecord> implements Record2<String, String> {

    private static final long serialVersionUID = -763303850;

    /**
     * Setter for <code>orderlyweb_report_version_tag.report_version</code>.
     */
    public void setReportVersion(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>orderlyweb_report_version_tag.report_version</code>.
     */
    public String getReportVersion() {
        return (String) get(0);
    }

    /**
     * Setter for <code>orderlyweb_report_version_tag.tag</code>.
     */
    public void setTag(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>orderlyweb_report_version_tag.tag</code>.
     */
    public String getTag() {
        return (String) get(1);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record2<String, String> key() {
        return (Record2) super.key();
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row2<String, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    @Override
    public Row2<String, String> valuesRow() {
        return (Row2) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return OrderlywebReportVersionTag.ORDERLYWEB_REPORT_VERSION_TAG.REPORT_VERSION;
    }

    @Override
    public Field<String> field2() {
        return OrderlywebReportVersionTag.ORDERLYWEB_REPORT_VERSION_TAG.TAG;
    }

    @Override
    public String component1() {
        return getReportVersion();
    }

    @Override
    public String component2() {
        return getTag();
    }

    @Override
    public String value1() {
        return getReportVersion();
    }

    @Override
    public String value2() {
        return getTag();
    }

    @Override
    public OrderlywebReportVersionTagRecord value1(String value) {
        setReportVersion(value);
        return this;
    }

    @Override
    public OrderlywebReportVersionTagRecord value2(String value) {
        setTag(value);
        return this;
    }

    @Override
    public OrderlywebReportVersionTagRecord values(String value1, String value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached OrderlywebReportVersionTagRecord
     */
    public OrderlywebReportVersionTagRecord() {
        super(OrderlywebReportVersionTag.ORDERLYWEB_REPORT_VERSION_TAG);
    }

    /**
     * Create a detached, initialised OrderlywebReportVersionTagRecord
     */
    public OrderlywebReportVersionTagRecord(String reportVersion, String tag) {
        super(OrderlywebReportVersionTag.ORDERLYWEB_REPORT_VERSION_TAG);

        set(0, reportVersion);
        set(1, tag);
    }
}
