package controller;

import models.Course;
import models.CourseDAO;
import views.CourseView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class CourseController {
    private CourseView view;
    private CourseDAO model;

    public CourseController(CourseView view, CourseDAO model) {
        this.view = view;
        this.model = model;

        // Populate teacher names in the JComboBox
        populateTeacherNames();

        // Attach event handlers
        attachEventHandlers();

        // Load data into the table
        loadTableData();
    }

    private void populateTeacherNames() {
        List<String> teachers = model.getAllTeacherNames();
        JComboBox<String> comboTcID = view.getComboTcID();
        for (String teacher : teachers) {
            comboTcID.addItem(teacher);
        }
    }

    private void attachEventHandlers() {
        view.getBtnSave().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveCourse();
            }
        });

        view.getBtnUpdate().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateCourse();
            }
        });

        view.getBtnDelete().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteCourse();
            }
        });

        view.getTable().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int index = view.getTable().getSelectedRow();
                DefaultTableModel model = (DefaultTableModel) view.getTable().getModel();
                view.getTxtID().setText(model.getValueAt(index, 0).toString());
                view.getTxtName().setText(model.getValueAt(index, 1).toString());
                view.getComboTcID().setSelectedItem(model.getValueAt(index, 2).toString());
                view.getTxtCategory().setText(model.getValueAt(index, 3).toString());
            }
        });
    }

    private void loadTableData() {
        List<Course> courses = model.getAllCourses();
        DefaultTableModel tableModel = (DefaultTableModel) view.getTable().getModel();
        tableModel.setRowCount(0);
        tableModel.setColumnIdentifiers(new Object[]{"ID", "Name", "Teacher", "Category"}); // Ensure column headers are set
        for (Course course : courses) {
            tableModel.addRow(new Object[]{course.getId(), course.getName(), course.getTeacherName(), course.getCategory()});
        }
    }

    private void saveCourse() {
        String name = view.getTxtName().getText();
        String teacherName = (String) view.getComboTcID().getSelectedItem();
        String category = view.getTxtCategory().getText();

        if (name.isEmpty() || teacherName.isEmpty() || category.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Please fill all fields");
            return;
        }

        Course course = new Course();
        course.setName(name);
        course.setTeacherName(teacherName);
        course.setCategory(category);

        model.addCourse(course);
        JOptionPane.showMessageDialog(view, "Course saved successfully");
        clearFields();
        loadTableData();
    }

    private void updateCourse() {
        String id = view.getTxtID().getText();
        String name = view.getTxtName().getText();
        String teacherName = (String) view.getComboTcID().getSelectedItem();
        String category = view.getTxtCategory().getText();

        if (id.isEmpty() || name.isEmpty() || teacherName.isEmpty() || category.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Please fill all fields");
            return;
        }

        Course course = new Course();
        course.setId(Integer.parseInt(id));
        course.setName(name);
        course.setTeacherName(teacherName);
        course.setCategory(category);

        model.updateCourse(course);
        JOptionPane.showMessageDialog(view, "Course updated successfully");
        clearFields();
        loadTableData();
    }

    private void deleteCourse() {
        String id = view.getTxtID().getText();

        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Please select a course to delete");
            return;
        }

        int result = JOptionPane.showConfirmDialog(view, "Are you sure you want to delete this course?", "Delete", JOptionPane.YES_NO_OPTION);

        if (result == JOptionPane.YES_OPTION) {
            model.deleteCourse(Integer.parseInt(id));
            JOptionPane.showMessageDialog(view, "Course deleted successfully");
            clearFields();
            loadTableData();
        }
    }

    private void clearFields() {
        view.getTxtID().setText("");
        view.getTxtName().setText("");
        view.getComboTcID().setSelectedIndex(-1);
        view.getTxtCategory().setText("");
    }
}
