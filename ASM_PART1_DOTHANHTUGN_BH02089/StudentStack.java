class StudentStack {
    private int maxSize;
    private Student[] stackArray;
    private int top;

    public StudentStack(int size) {
        maxSize = size;
        stackArray = new Student[maxSize];
        top = -1; 
    }

    public void push(Student s) {
        if (isFull()) {
            System.out.println("Stack is full, can't push new student.");
        } else {
            stackArray[++top] = s;
        }
    }

    public Student pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty, can't pop.");
            return null;
        } else {
            return stackArray[top--];
        }
    }

    public Student peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty, can't peek.");
            return null;
        } else {
            return stackArray[top];
        }
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == maxSize - 1);
    }

    public int size() {
        return top + 1;
    }

    public void printStack() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
        } else {
            for (int i = top; i >= 0; i--) {
                System.out.println(stackArray[i].toString());
            }
        }
    }
}
