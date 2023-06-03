package by.it_academy.jd2.Mk_JD2_98_23.core.enums;

public enum Status {
        UNASSIGNED ("unassigned"),
        PENDING ("pending"),
        ACCEPTED ("accepted"),
        STARTED ("started"),
        COMPLETED ("completed");

        private final String title;

        Status(String title) {
                this.title = title;
        }

        public String getTitle() {
                return title;
        }
}
