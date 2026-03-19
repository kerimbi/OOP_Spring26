 @Override
    public String toString() {
        return "Account[" + accNumber + ", balance=$" + String.format("%.2f", balance) + "]";
    }

    public final void print() { System.out.println(toString()); }