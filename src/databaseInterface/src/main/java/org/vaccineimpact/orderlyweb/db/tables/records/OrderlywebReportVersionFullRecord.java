/*
 * This file is generated by jOOQ.
*/
package org.vaccineimpact.orderlyweb.db.tables.records;


import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record13;
import org.jooq.Row13;
import org.jooq.impl.TableRecordImpl;
import org.vaccineimpact.orderlyweb.db.tables.OrderlywebReportVersionFull;


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
public class OrderlywebReportVersionFullRecord extends TableRecordImpl<OrderlywebReportVersionFullRecord> implements Record13<String, String, Timestamp, String, String, Boolean, Double, String, String, Boolean, String, String, Boolean> {

    private static final long serialVersionUID = -784240967;

    /**
     * Setter for <code>orderlyweb_report_version_full.id</code>.
     */
    public void setId(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>orderlyweb_report_version_full.id</code>.
     */
    public String getId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>orderlyweb_report_version_full.report</code>.
     */
    public void setReport(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>orderlyweb_report_version_full.report</code>.
     */
    public String getReport() {
        return (String) get(1);
    }

    /**
     * Setter for <code>orderlyweb_report_version_full.date</code>.
     */
    public void setDate(Timestamp value) {
        set(2, value);
    }

    /**
     * Getter for <code>orderlyweb_report_version_full.date</code>.
     */
    public Timestamp getDate() {
        return (Timestamp) get(2);
    }

    /**
     * Setter for <code>orderlyweb_report_version_full.displayname</code>.
     */
    public void setDisplayname(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>orderlyweb_report_version_full.displayname</code>.
     */
    public String getDisplayname() {
        return (String) get(3);
    }

    /**
     * Setter for <code>orderlyweb_report_version_full.description</code>.
     */
    public void setDescription(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>orderlyweb_report_version_full.description</code>.
     */
    public String getDescription() {
        return (String) get(4);
    }

    /**
     * Setter for <code>orderlyweb_report_version_full.connection</code>.
     */
    public void setConnection(Boolean value) {
        set(5, value);
    }

    /**
     * Getter for <code>orderlyweb_report_version_full.connection</code>.
     */
    public Boolean getConnection() {
        return (Boolean) get(5);
    }

    /**
     * Setter for <code>orderlyweb_report_version_full.elapsed</code>.
     */
    public void setElapsed(Double value) {
        set(6, value);
    }

    /**
     * Getter for <code>orderlyweb_report_version_full.elapsed</code>.
     */
    public Double getElapsed() {
        return (Double) get(6);
    }

    /**
     * Setter for <code>orderlyweb_report_version_full.git_sha</code>.
     */
    public void setGitSha(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>orderlyweb_report_version_full.git_sha</code>.
     */
    public String getGitSha() {
        return (String) get(7);
    }

    /**
     * Setter for <code>orderlyweb_report_version_full.git_branch</code>.
     */
    public void setGitBranch(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>orderlyweb_report_version_full.git_branch</code>.
     */
    public String getGitBranch() {
        return (String) get(8);
    }

    /**
     * Setter for <code>orderlyweb_report_version_full.git_clean</code>.
     */
    public void setGitClean(Boolean value) {
        set(9, value);
    }

    /**
     * Getter for <code>orderlyweb_report_version_full.git_clean</code>.
     */
    public Boolean getGitClean() {
        return (Boolean) get(9);
    }

    /**
     * Setter for <code>orderlyweb_report_version_full.requester</code>.
     */
    public void setRequester(String value) {
        set(10, value);
    }

    /**
     * Getter for <code>orderlyweb_report_version_full.requester</code>.
     */
    public String getRequester() {
        return (String) get(10);
    }

    /**
     * Setter for <code>orderlyweb_report_version_full.author</code>.
     */
    public void setAuthor(String value) {
        set(11, value);
    }

    /**
     * Getter for <code>orderlyweb_report_version_full.author</code>.
     */
    public String getAuthor() {
        return (String) get(11);
    }

    /**
     * Setter for <code>orderlyweb_report_version_full.published</code>.
     */
    public void setPublished(Boolean value) {
        set(12, value);
    }

    /**
     * Getter for <code>orderlyweb_report_version_full.published</code>.
     */
    public Boolean getPublished() {
        return (Boolean) get(12);
    }

    // -------------------------------------------------------------------------
    // Record13 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row13<String, String, Timestamp, String, String, Boolean, Double, String, String, Boolean, String, String, Boolean> fieldsRow() {
        return (Row13) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row13<String, String, Timestamp, String, String, Boolean, Double, String, String, Boolean, String, String, Boolean> valuesRow() {
        return (Row13) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return OrderlywebReportVersionFull.ORDERLYWEB_REPORT_VERSION_FULL.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return OrderlywebReportVersionFull.ORDERLYWEB_REPORT_VERSION_FULL.REPORT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field3() {
        return OrderlywebReportVersionFull.ORDERLYWEB_REPORT_VERSION_FULL.DATE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return OrderlywebReportVersionFull.ORDERLYWEB_REPORT_VERSION_FULL.DISPLAYNAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return OrderlywebReportVersionFull.ORDERLYWEB_REPORT_VERSION_FULL.DESCRIPTION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Boolean> field6() {
        return OrderlywebReportVersionFull.ORDERLYWEB_REPORT_VERSION_FULL.CONNECTION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Double> field7() {
        return OrderlywebReportVersionFull.ORDERLYWEB_REPORT_VERSION_FULL.ELAPSED;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field8() {
        return OrderlywebReportVersionFull.ORDERLYWEB_REPORT_VERSION_FULL.GIT_SHA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field9() {
        return OrderlywebReportVersionFull.ORDERLYWEB_REPORT_VERSION_FULL.GIT_BRANCH;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Boolean> field10() {
        return OrderlywebReportVersionFull.ORDERLYWEB_REPORT_VERSION_FULL.GIT_CLEAN;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field11() {
        return OrderlywebReportVersionFull.ORDERLYWEB_REPORT_VERSION_FULL.REQUESTER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field12() {
        return OrderlywebReportVersionFull.ORDERLYWEB_REPORT_VERSION_FULL.AUTHOR;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Boolean> field13() {
        return OrderlywebReportVersionFull.ORDERLYWEB_REPORT_VERSION_FULL.PUBLISHED;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getReport();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value3() {
        return getDate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getDisplayname();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getDescription();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean value6() {
        return getConnection();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double value7() {
        return getElapsed();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value8() {
        return getGitSha();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value9() {
        return getGitBranch();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean value10() {
        return getGitClean();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value11() {
        return getRequester();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value12() {
        return getAuthor();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean value13() {
        return getPublished();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OrderlywebReportVersionFullRecord value1(String value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OrderlywebReportVersionFullRecord value2(String value) {
        setReport(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OrderlywebReportVersionFullRecord value3(Timestamp value) {
        setDate(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OrderlywebReportVersionFullRecord value4(String value) {
        setDisplayname(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OrderlywebReportVersionFullRecord value5(String value) {
        setDescription(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OrderlywebReportVersionFullRecord value6(Boolean value) {
        setConnection(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OrderlywebReportVersionFullRecord value7(Double value) {
        setElapsed(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OrderlywebReportVersionFullRecord value8(String value) {
        setGitSha(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OrderlywebReportVersionFullRecord value9(String value) {
        setGitBranch(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OrderlywebReportVersionFullRecord value10(Boolean value) {
        setGitClean(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OrderlywebReportVersionFullRecord value11(String value) {
        setRequester(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OrderlywebReportVersionFullRecord value12(String value) {
        setAuthor(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OrderlywebReportVersionFullRecord value13(Boolean value) {
        setPublished(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OrderlywebReportVersionFullRecord values(String value1, String value2, Timestamp value3, String value4, String value5, Boolean value6, Double value7, String value8, String value9, Boolean value10, String value11, String value12, Boolean value13) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        value12(value12);
        value13(value13);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached OrderlywebReportVersionFullRecord
     */
    public OrderlywebReportVersionFullRecord() {
        super(OrderlywebReportVersionFull.ORDERLYWEB_REPORT_VERSION_FULL);
    }

    /**
     * Create a detached, initialised OrderlywebReportVersionFullRecord
     */
    public OrderlywebReportVersionFullRecord(String id, String report, Timestamp date, String displayname, String description, Boolean connection, Double elapsed, String gitSha, String gitBranch, Boolean gitClean, String requester, String author, Boolean published) {
        super(OrderlywebReportVersionFull.ORDERLYWEB_REPORT_VERSION_FULL);

        set(0, id);
        set(1, report);
        set(2, date);
        set(3, displayname);
        set(4, description);
        set(5, connection);
        set(6, elapsed);
        set(7, gitSha);
        set(8, gitBranch);
        set(9, gitClean);
        set(10, requester);
        set(11, author);
        set(12, published);
    }
}
