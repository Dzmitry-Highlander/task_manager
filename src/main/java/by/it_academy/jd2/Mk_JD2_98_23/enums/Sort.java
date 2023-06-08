package by.it_academy.jd2.Mk_JD2_98_23.enums;

public enum Sort {
    ID_ASC ("task_id ASC"),
    ID_DESC ("task_id DESC"),
    HEADER_ASC ("header ASC"),
    HEADER_DESC ("header DESC"),
    DEADLINE_ASC ("deadline ASC"),
    DEADLINE_DESC ("deadline DESC"),
    STATUS_ASC ("status ASC"),
    STATUS_DESC ("status DESC");

    private final String sort;

    Sort(String sort) {
        this.sort = sort;
    }

    public String getSort() {
        return sort;
    }
}
