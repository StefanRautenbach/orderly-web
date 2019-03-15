/*
 * This file is generated by jOOQ.
*/
package org.vaccineimpact.orderlyweb.db.tables.records;


import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record6;
import org.jooq.Row6;
import org.jooq.impl.UpdatableRecordImpl;
import org.vaccineimpact.orderlyweb.db.tables.Depends;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class DependsRecord extends UpdatableRecordImpl<DependsRecord> implements Record6<Integer, String, Integer, String, Boolean, Boolean> {

    private static final long serialVersionUID = 122202403;

    /**
     * Setter for <code>depends.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>depends.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>depends.report_version</code>.
     */
    public void setReportVersion(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>depends.report_version</code>.
     */
    public String getReportVersion() {
        return (String) get(1);
    }

    /**
     * Setter for <code>depends.use</code>.
     */
    public void setUse(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>depends.use</code>.
     */
    public Integer getUse() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>depends.as</code>.
     */
    public void setAs(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>depends.as</code>.
     */
    public String getAs() {
        return (String) get(3);
    }

    /**
     * Setter for <code>depends.is_pinned</code>.
     */
    public void setIsPinned(Boolean value) {
        set(4, value);
    }

    /**
     * Getter for <code>depends.is_pinned</code>.
     */
    public Boolean getIsPinned() {
        return (Boolean) get(4);
    }

    /**
     * Setter for <code>depends.is_latest</code>.
     */
    public void setIsLatest(Boolean value) {
        set(5, value);
    }

    /**
     * Getter for <code>depends.is_latest</code>.
     */
    public Boolean getIsLatest() {
        return (Boolean) get(5);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record6 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row6<Integer, String, Integer, String, Boolean, Boolean> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row6<Integer, String, Integer, String, Boolean, Boolean> valuesRow() {
        return (Row6) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return Depends.DEPENDS.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Depends.DEPENDS.REPORT_VERSION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field3() {
        return Depends.DEPENDS.USE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return Depends.DEPENDS.AS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Boolean> field5() {
        return Depends.DEPENDS.IS_PINNED;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Boolean> field6() {
        return Depends.DEPENDS.IS_LATEST;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getReportVersion();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value3() {
        return getUse();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getAs();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean value5() {
        return getIsPinned();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean value6() {
        return getIsLatest();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DependsRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DependsRecord value2(String value) {
        setReportVersion(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DependsRecord value3(Integer value) {
        setUse(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DependsRecord value4(String value) {
        setAs(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DependsRecord value5(Boolean value) {
        setIsPinned(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DependsRecord value6(Boolean value) {
        setIsLatest(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DependsRecord values(Integer value1, String value2, Integer value3, String value4, Boolean value5, Boolean value6) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached DependsRecord
     */
    public DependsRecord() {
        super(Depends.DEPENDS);
    }

    /**
     * Create a detached, initialised DependsRecord
     */
    public DependsRecord(Integer id, String reportVersion, Integer use, String as, Boolean isPinned, Boolean isLatest) {
        super(Depends.DEPENDS);

        set(0, id);
        set(1, reportVersion);
        set(2, use);
        set(3, as);
        set(4, isPinned);
        set(5, isLatest);
    }
}