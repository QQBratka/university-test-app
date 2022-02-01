package com.example.universitytestproject.controller.inject;

import com.example.universitytestproject.model.Day;
import com.example.universitytestproject.model.Group;
import com.example.universitytestproject.model.Professor;
import com.example.universitytestproject.model.Schedule;
import com.example.universitytestproject.model.Speciality;
import com.example.universitytestproject.model.Student;
import com.example.universitytestproject.model.Subject;
import com.example.universitytestproject.servise.GroupService;
import com.example.universitytestproject.servise.ProfessorService;
import com.example.universitytestproject.servise.ScheduleService;
import com.example.universitytestproject.servise.StudentService;
import com.example.universitytestproject.servise.SubjectService;
import java.util.List;
import javax.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class InjectDataController {
    private final GroupService groupService;
    private final ScheduleService scheduleService;
    private final SubjectService subjectService;
    private final StudentService studentService;
    private final ProfessorService professorService;

    @PostConstruct
    private void injectData() {
        injectProfessors();
        injectSubjects();
        injectSchedules();
        injectGroups();
        injectStudents();
    }

    public void injectProfessors() {
        // for all
        Professor mennigan = new Professor("Mennigan", 39, 6);
        Professor volder = new Professor("Volder", 52, 21);
        Professor fisotenko = new Professor("Fisotenko", 36, 9);
        Professor donavan = new Professor("Donavan", 43, 12);
        Professor pozniak = new Professor("Pozniak", 32, 7);
        Professor sirento = new Professor("Sirento", 26, 1);
        // for half
        Professor stesenko = new Professor("Stesenko", 39, 12);
        Professor mizin = new Professor("Mizin", 31, 3);
        Professor ushew = new Professor("Ushew", 47, 19);
        Professor voloshin = new Professor("Voloshin", 29, 4);
        Professor fedko = new Professor("Fedko", 35, 5);
        // profile
        Professor azov = new Professor("Azov", 67, 39);
        Professor veniuk = new Professor("Veniuk", 49, 25);
        Professor erovski = new Professor("Erovski", 54, 11);
        Professor zolont = new Professor("Zolont", 35, 7);
        // inject
        List<Professor> professors = List.of(mennigan, volder, fisotenko, donavan, pozniak, sirento,
                stesenko, mizin, ushew, voloshin, fedko, azov, veniuk, erovski, zolont);
        for (Professor professor : professors) {
            professorService.create(professor);
        }
    }

    public void injectSubjects() {
        // for all
        Subject history = new Subject("history", 102, professorService.get(1L));
        Subject english = new Subject("english", 102, professorService.get(1L));
        Subject economic = new Subject("economic", 103, professorService.get(2L));
        Subject math = new Subject("math", 103, professorService.get(2L));
        Subject physic = new Subject("physic", 104, professorService.get(3L));
        Subject philosophy = new Subject("philosophy", 104, professorService.get(3L));
        Subject informatics = new Subject("informatics", 105, professorService.get(4L));
        Subject low = new Subject("low", 105, professorService.get(4L));
        Subject ukrainian = new Subject("ukrainian", 106, professorService.get(5L));
        Subject healthCulture = new Subject("health_culture", 101, professorService.get(6L));
        // for Economics and History
        Subject literature = new Subject("literature", 201, professorService.get(7L));
        Subject biology = new Subject("biology", 202, professorService.get(7L));
        Subject geography = new Subject("geography", 203, professorService.get(8L));
        Subject psychology = new Subject("psychology", 204, professorService.get(8L));
        Subject sociology = new Subject("sociology", 205, professorService.get(9L));
        // for IT and Physics
        Subject astronomy = new Subject("astronomy", 206, professorService.get(9L));
        Subject highMath = new Subject("high_math", 207, professorService.get(10L));
        Subject booleanMath = new Subject("boolean_math", 305, professorService.get(10L));
        Subject chemistry = new Subject("chemistry", 306, professorService.get(11L));
        Subject discreteMath = new Subject("discrete_math", 307, professorService.get(11L));
        // for Economics
        Subject accounting = new Subject("accounting", 301, professorService.get(12L));
        Subject financial = new Subject("financial", 301,professorService.get(12L));
        Subject economicHistory = new Subject("economic_history", 301, professorService.get(12L));
        Subject macroEconomic = new Subject("macro_economic", 301, professorService.get(12L));
        Subject socialEconomic = new Subject("social_economic", 301, professorService.get(12L));
        // for IT
        Subject algorithms = new Subject("algorithms", 302, professorService.get(13L));
        Subject java = new Subject("java", 302, professorService.get(13L));
        Subject cyberSecurity = new Subject("cyber_security", 302, professorService.get(13L));
        Subject web = new Subject("web", 302, professorService.get(13L));
        Subject python = new Subject("python", 302, professorService.get(13L));
        // for History
        Subject modernHistory = new Subject("modern_history", 303, professorService.get(14L));
        Subject ancientWorld = new Subject("ancient_world", 303, professorService.get(14L));
        Subject culture = new Subject("culture", 303, professorService.get(14L));
        Subject politology = new Subject("politology", 303, professorService.get(14L));
        Subject archeology = new Subject("archeology", 303, professorService.get(14L));
        // for Physics
        Subject nuclear = new Subject("nuclear", 304, professorService.get(15L));
        Subject quantum = new Subject("quantum", 304, professorService.get(15L));
        Subject molecular = new Subject("molecular", 304, professorService.get(15L));
        Subject biophysics = new Subject("biophysics", 304, professorService.get(15L));
        Subject geophysics = new Subject("geophysics", 304, professorService.get(15L));
        // inject
        List<Subject> subjects = List.of(history, english, economic, math, physic, philosophy,
                healthCulture, informatics, low, ukrainian, literature, biology, geography,
                psychology, sociology, highMath, booleanMath, chemistry, astronomy, discreteMath,
                accounting, financial, economicHistory, macroEconomic, socialEconomic, algorithms,
                java, cyberSecurity, web, python, modernHistory, ancientWorld, culture, politology,
                archeology, nuclear, quantum, molecular, biophysics, geophysics);
        for (Subject subject : subjects) {
            subjectService.create(subject);
        }
    }

    public void injectSchedules() {
        // Economics week
        Schedule mondayEconomic = new Schedule(Day.MONDAY, Speciality.ECONOMICS,
                List.of(subjectService.get(1L), subjectService.get(2L),
                        subjectService.get(11L), subjectService.get(21L)));
        Schedule tuesdayEconomic = new Schedule(Day.TUESDAY, Speciality.ECONOMICS,
                List.of(subjectService.get(9L), subjectService.get(10L),
                        subjectService.get(12L), subjectService.get(22L)));
        Schedule wednesdayEconomic = new Schedule(Day.WEDNESDAY, Speciality.ECONOMICS,
                List.of(subjectService.get(7L), subjectService.get(8L),
                        subjectService.get(13L), subjectService.get(23L)));
        Schedule thursdayEconomic = new Schedule(Day.THURSDAY, Speciality.ECONOMICS,
                List.of(subjectService.get(5L), subjectService.get(6L), subjectService.get(14L),
                        subjectService.get(24L)));
        Schedule fridayEconomic = new Schedule(Day.FRIDAY, Speciality.ECONOMICS,
                List.of(subjectService.get(3L), subjectService.get(4L),
                        subjectService.get(15L), subjectService.get(25L)));
        // IT week
        Schedule mondayIt = new Schedule(Day.MONDAY, Speciality.INTERNET_TECHNOLOGIES,
                List.of(subjectService.get(3L), subjectService.get(4L),
                        subjectService.get(16L), subjectService.get(26L)));
        Schedule tuesdayIt = new Schedule(Day.TUESDAY, Speciality.INTERNET_TECHNOLOGIES,
                List.of(subjectService.get(1L), subjectService.get(2L),
                        subjectService.get(17L), subjectService.get(27L)));
        Schedule wednesdayIt = new Schedule(Day.WEDNESDAY, Speciality.INTERNET_TECHNOLOGIES,
                List.of(subjectService.get(9L), subjectService.get(10L),
                        subjectService.get(18L), subjectService.get(28L)));
        Schedule thursdayIt = new Schedule(Day.THURSDAY, Speciality.INTERNET_TECHNOLOGIES,
                List.of(subjectService.get(7L), subjectService.get(8L),
                        subjectService.get(19L), subjectService.get(29L)));
        Schedule fridayIt = new Schedule(Day.FRIDAY, Speciality.INTERNET_TECHNOLOGIES,
                List.of(subjectService.get(5L), subjectService.get(6L),
                        subjectService.get(20L), subjectService.get(30L)));
        // History week
        Schedule mondayHistory = new Schedule(Day.MONDAY, Speciality.HISTORICAL,
                List.of(subjectService.get(5L), subjectService.get(6L),
                        subjectService.get(11L), subjectService.get(31L)));
        Schedule tuesdayHistory = new Schedule(Day.TUESDAY, Speciality.HISTORICAL,
                List.of(subjectService.get(3L), subjectService.get(4L),
                        subjectService.get(12L), subjectService.get(32L)));
        Schedule wednesdayHistory = new Schedule(Day.WEDNESDAY, Speciality.HISTORICAL,
                List.of(subjectService.get(1L), subjectService.get(2L),
                        subjectService.get(13L), subjectService.get(33L)));
        Schedule thursdayHistory = new Schedule(Day.THURSDAY, Speciality.HISTORICAL,
                List.of(subjectService.get(9L), subjectService.get(10L),
                        subjectService.get(14L), subjectService.get(34L)));
        Schedule fridayHistory = new Schedule(Day.FRIDAY, Speciality.HISTORICAL,
                List.of(subjectService.get(7L), subjectService.get(8L),
                        subjectService.get(15L), subjectService.get(35L)));
        // Physics week
        Schedule mondayPhysics = new Schedule(Day.MONDAY, Speciality.PHYSICS,
                List.of(subjectService.get(7L), subjectService.get(8L),
                        subjectService.get(16L), subjectService.get(36L)));
        Schedule tuesdayPhysics = new Schedule(Day.TUESDAY, Speciality.PHYSICS,
                List.of(subjectService.get(5L), subjectService.get(6L),
                        subjectService.get(17L), subjectService.get(37L)));
        Schedule wednesdayPhysics = new Schedule(Day.WEDNESDAY, Speciality.PHYSICS,
                List.of(subjectService.get(3L), subjectService.get(4L),
                        subjectService.get(18L), subjectService.get(38L)));
        Schedule thursdayPhysics = new Schedule(Day.THURSDAY, Speciality.PHYSICS,
                List.of(subjectService.get(1L), subjectService.get(2L),
                        subjectService.get(19L), subjectService.get(39L)));
        Schedule fridayPhysics = new Schedule(Day.FRIDAY, Speciality.PHYSICS,
                List.of(subjectService.get(9L), subjectService.get(10L),
                        subjectService.get(20L), subjectService.get(40L)));
        // inject
        List<Schedule> schedules = List.of(mondayEconomic, mondayIt, mondayHistory, mondayPhysics,
                tuesdayEconomic, tuesdayIt, tuesdayHistory, tuesdayPhysics,
                wednesdayEconomic, wednesdayIt, wednesdayHistory, wednesdayPhysics,
                thursdayEconomic, thursdayIt, thursdayHistory, thursdayPhysics,
                fridayEconomic, fridayIt, fridayHistory, fridayPhysics);
        for (Schedule schedule : schedules) {
            scheduleService.create(schedule);
        }
    }

    public void injectGroups() {
        // creating groups
        Group economics = new Group(Speciality.ECONOMICS, List.of(professorService.get(1L),
                professorService.get(2L), professorService.get(3L), professorService.get(4L),
                professorService.get(5L), professorService.get(6L), professorService.get(7L),
                professorService.get(8L), professorService.get(9L), professorService.get(12L)),
                List.of(scheduleService.get(1L),
                scheduleService.get(5L), scheduleService.get(9L),
                scheduleService.get(13L), scheduleService.get(17L)));
        Group it = new Group(Speciality.INTERNET_TECHNOLOGIES, List.of(professorService.get(1L),
                professorService.get(2L), professorService.get(3L), professorService.get(4L),
                professorService.get(5L), professorService.get(6L), professorService.get(9L),
                professorService.get(10L), professorService.get(11L), professorService.get(13L)),
                List.of(scheduleService.get(2L),
                scheduleService.get(6L), scheduleService.get(10L),
                scheduleService.get(14L), scheduleService.get(18L)));
        Group historical = new Group(Speciality.HISTORICAL, List.of(professorService.get(1L),
                professorService.get(2L), professorService.get(3L), professorService.get(4L),
                professorService.get(5L), professorService.get(6L), professorService.get(7L),
                professorService.get(8L), professorService.get(9L), professorService.get(14L)),
                List.of(scheduleService.get(3L),
                scheduleService.get(7L), scheduleService.get(11L),
                scheduleService.get(15L), scheduleService.get(19L)));
        Group physics = new Group(Speciality.PHYSICS, List.of(professorService.get(1L),
                professorService.get(2L), professorService.get(3L), professorService.get(4L),
                professorService.get(5L), professorService.get(6L), professorService.get(9L),
                professorService.get(10L), professorService.get(11L), professorService.get(15L)),
                List.of(scheduleService.get(4L),
                scheduleService.get(8L), scheduleService.get(12L),
                scheduleService.get(16L), scheduleService.get(20L)));
        // inject
        List<Group> groups = List.of(economics,it, historical, physics);
        for (Group group : groups) {
            groupService.create(group);
        }
    }

    public void injectStudents() {
        // first letter and second letter means abbreviation of name/lastname, last letter means speciality
        // Economics
        // course 1
        Student wse = new Student("Will", "Smith", 19, 1, groupService.get(1L));
        Student jde = new Student("Johnny", "Depp", 19, 1, groupService.get(1L));
        Student ase = new Student("Adam", "Sandler", 20, 1, groupService.get(1L));
        Student vde = new Student("Vin", "Diesel", 19, 1, groupService.get(1L));
        Student jce = new Student("Jackie", "Chan", 22, 1, groupService.get(1L));
        // course 2
        Student mfe = new Student("Morgan", "Freeman", 21, 2, groupService.get(1L));
        Student rwe = new Student("Angelina", "Jolie", 20, 2, groupService.get(1L));
        Student aje = new Student("Brad", "Pitt", 19, 2, groupService.get(1L));
        Student bpe = new Student("Will", "Smith", 21, 2, groupService.get(1L));
        Student jke = new Student("Jim", "Carey", 26, 2, groupService.get(1L));
        //course 3
        Student nce = new Student("Nicholas", "Cage", 22, 3, groupService.get(1L));
        Student lde = new Student("Leonardo", "DiCaprio", 21, 3, groupService.get(1L));
        Student jae = new Student("Jennifer", "Anniston", 21, 3, groupService.get(1L));
        Student bwe = new Student("Bruce", "Willis", 29, 3, groupService.get(1L));
        Student sbe = new Student("Sandra", "Bullock", 23, 3, groupService.get(1L));
        // IT
        // course 1
        Student tci = new Student("Tom", "Cruise", 19, 1, groupService.get(2L));
        Student cdi = new Student("Cameron", "Diaz", 19, 1, groupService.get(2L));
        Student emi = new Student("Eddie", "Murphy", 20, 1, groupService.get(2L));
        Student bsi = new Student("Ben", "Stiller", 19, 1, groupService.get(2L));
        Student ssi = new Student("Silvester", "Stallone", 22, 1, groupService.get(2L));
        // course 2
        Student rdi = new Student("Robert", "DeNiro", 21, 2, groupService.get(2L));
        Student asi = new Student("Arnold", "Schwarzenegger", 20, 2, groupService.get(2L));
        Student thi = new Student("Tom", "Hanks", 19, 2, groupService.get(2L));
        Student sji = new Student("Scarlett", "Johansson", 21, 2, groupService.get(2L));
        Student jri = new Student("Julia", "Roberts", 26, 2, groupService.get(2L));
        //course 3
        Student owi = new Student("Owen", "Wilson", 22, 3, groupService.get(2L));
        Student mdi = new Student("Matt", "Damon", 21, 3, groupService.get(2L));
        Student mfi = new Student("Megan", "Fox", 21, 3, groupService.get(2L));
        Student kri = new Student("Keanu", "Reeves", 29, 3, groupService.get(2L));
        Student obi = new Student("Orlando", "Bloom", 23, 3, groupService.get(2L));
        // History
        // course 1
        Student jch = new Student("George", "Clooney", 19, 1, groupService.get(3L));
        Student mgh = new Student("Mel", "Gibson", 19, 1, groupService.get(3L));
        Student bfh = new Student("Brendan", "Fraser", 20, 1, groupService.get(3L));
        Student msh = new Student("Meryl", "Streep", 19, 1, groupService.get(3L));
        Student dbh = new Student("Drew", "Barrymore", 22, 1, groupService.get(3L));
        // course 2
        Student ahh = new Student("Anthony", "Hopkins", 21, 2, groupService.get(3L));
        Student nph = new Student("Natalie", "Portman", 20, 2, groupService.get(3L));
        Student mlh = new Student("Martin", "Lawrence", 19, 2, groupService.get(3L));
        Student jnh = new Student("Jack", "Nicholson", 21, 2, groupService.get(3L));
        Student rgh = new Student("Richard", "Gere", 26, 2, groupService.get(3L));
        //course 3
        Student aph = new Student("Al", "Pacino", 22, 3, groupService.get(3L));
        Student jah = new Student("Jessica", "Alba", 21, 3, groupService.get(3L));
        Student shh = new Student("Salma", "Hayek", 21, 3, groupService.get(3L));
        Student hfh = new Student("Harrison", "Ford", 29, 3, groupService.get(3L));
        Student pch = new Student("Penelope", "Cruz", 23, 3, groupService.get(3L));
        // Physics
        // course 1
        Student sjp = new Student("Samuel", "LJackson", 19, 1, groupService.get(4L));
        Student nkp = new Student("Nicole", "Kidman", 19, 1, groupService.get(4L));
        Student czp = new Student("Catherine", "ZetaJones", 20, 1, groupService.get(4L));
        Student cgp = new Student("Cuba", "GoodingJr", 19, 1, groupService.get(4L));
        Student scp = new Student("Sean", "Connery", 22, 1, groupService.get(4L));
        // course 2
        Student llp = new Student("Lindsay", "Lohan", 21, 2, groupService.get(4L));
        Student jbp = new Student("Jack", "Black", 20, 2, groupService.get(4L));
        Student cep = new Student("Clint", "Eastwood", 19, 2, groupService.get(4L));
        Student kcp = new Student("Kevin", "Costner", 21, 2, groupService.get(4L));
        Student kkp = new Student("Keira", "Knightley", 26, 2, groupService.get(4L));
        //course 3
        Student smp = new Student("Steve", "Martin", 22, 3, groupService.get(4L));
        Student skp = new Student("Steve", "Karrell", 21, 3, groupService.get(4L));
        Student mrp = new Student("Michelle", "Rodriguez", 21, 3, groupService.get(4L));
        Student mjp = new Student("Milla", "Jovovich", 29, 3, groupService.get(4L));
        Student ewp = new Student("Elijah", "Wood", 23, 3, groupService.get(4L));
        // inject
        List<Student> students = List.of(wse, jde, ase, vde, jce, mfe, rwe, aje, bpe, jke, nce, lde, jae, bwe, sbe,
                tci, cdi, emi, bsi, ssi, rdi, asi, thi, sji, jri, owi, mdi, mfi, kri, obi,
                jch, mgh, bfh, msh, dbh, ahh, nph, mlh, jnh, rgh, aph, jah, shh, hfh, pch,
                sjp, nkp, czp, cgp, scp, llp, jbp, cep, kcp, kkp, smp, skp, mrp, mjp, ewp);
        for (Student student : students) {
            studentService.create(student);
        }
    }
}
