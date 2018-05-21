public enum Priority {
    L0(0), L1(1), L2(2), L3(3), L4(4), L5(5), L6(6), L7(7), L8(8), L9(9), L10(10), L11(11);

    private int prio;

    Priority(int prio) {
        this.prio = prio;
    }

    public int getPrio() {
        return prio;
    }
}
