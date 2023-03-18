package Rikkei.academy;

import Rikkei.academy.Impl.StudentImpl;

import java.util.*;


public class DemergingQueue {
    public static void main(String[] args) {
        //* Sắp xếp sinh viên theo tuổi, sủ dụng Comperator
        ComparatorStudent comparatorStudent = new ComparatorStudent();
        Collections.sort(StudentImpl.studentList, comparatorStudent);
        List<Student> arr = StudentImpl.studentList; // Tạo mảng arr để viết cho ngắn :D
        System.out.println("Danh sách ban đầu:");
        System.out.println(arr);

        //* Tạo 2 queue NAM, NU
        Queue<Student> NAM = new LinkedList<>();
        Queue<Student> NU = new LinkedList<>();

        //* Đẩy giới tính nữ vào queue NU và nam vào queue NAM
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).getGender().equalsIgnoreCase("nu")) {
                NU.add(arr.get(i));
            } else {
                NAM.add(arr.get(i));
            }
        }

        //* Đưa student có giới tính nữ vào mà không ảnh hưởng đến việc sắp xếp theo tuổi trước đó
        ArrayList<Student> newArr = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            if (!NU.isEmpty()) {
                newArr.add(NU.poll());
                continue;
            }
            newArr.add(NAM.poll());
        }
        System.out.println("Danh sách mới là: ");
        System.out.println(newArr);
    }
}
