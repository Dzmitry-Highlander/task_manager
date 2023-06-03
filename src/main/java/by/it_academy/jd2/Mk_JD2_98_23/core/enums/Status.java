package by.it_academy.jd2.Mk_JD2_98_23.core.enums;

public enum Status {
        UNASSIGNED (0),
        PENDING (1),
        ACCEPTED (2),
        STARTED (3),
        COMPLETED (4);

        private final int status;

        Status(int status) {
                this.status = status;
        }

        public int getStatus() {
                return status;
        }
}
