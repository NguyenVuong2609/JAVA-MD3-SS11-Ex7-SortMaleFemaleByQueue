package Rikkei.academy;

import java.util.Comparator;

public class ComparatorStudent implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        int temp = o1.getAge() - o2.getAge();
        if (temp != 0)
            return temp;
        temp = o1.getName().compareTo(o2.getName());
        return temp;
    }
}
