package Rikkei.academy;

import Rikkei.academy.Impl.StudentImpl;

import java.util.*;


public class DemergingQueue {
    public static void main(String[] args) {
        ComparatorStudent comparatorStudent = new ComparatorStudent();
        Collections.sort(StudentImpl.studentList,comparatorStudent);
        List<Student> arr = StudentImpl.studentList;
        System.out.println("Danh sách ban đầu:");
        System.out.println(arr);
        Queue<Student> NAM = new LinkedList<>();
        Queue<Student> NU = new LinkedList<>();
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).getGender().equalsIgnoreCase("nu")){
                NU.add(arr.get(i));
            } else {
                NAM.add(arr.get(i));
            }
        }
        ArrayList<Student> newArr = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            if (!NU.isEmpty()){
                newArr.add(NU.poll());
                continue;
            }
            newArr.add(NAM.poll());
        }
        System.out.println("Danh sách mới là: ");
        System.out.println(newArr);
    }
}
