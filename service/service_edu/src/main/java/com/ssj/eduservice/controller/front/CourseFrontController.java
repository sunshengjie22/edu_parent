package com.ssj.eduservice.controller.front;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
//import com.ssj.commonutils.JwtUtils;
import com.ssj.commonutils.JwtUtils;
import com.ssj.commonutils.R;
import com.ssj.commonutils.ordervo.CourseWebVoOrder;
import com.ssj.eduservice.client.OrdersClient;
import com.ssj.eduservice.entity.EduCourse;
import com.ssj.eduservice.entity.chapter.ChapterVo;
import com.ssj.eduservice.entity.frontvo.CourseFrontVo;
import com.ssj.eduservice.entity.frontvo.CourseWebVo;
import com.ssj.eduservice.service.EduChapterService;
import com.ssj.eduservice.service.EduCourseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/eduservice/coursefront")
@CrossOrigin
public class CourseFrontController {

    @Autowired
    private EduCourseService courseService;

    @Autowired
    private EduChapterService chapterService;

    @Autowired
    private OrdersClient ordersClient;

    // 条件查询带分页的查询功能。required = false表示可以没有条件
    @PostMapping("/getFrontCourseList/{page}/{limit}")
    public R getFrontCourseList(@PathVariable long page, @PathVariable long limit,
                                @RequestBody(required = false) CourseFrontVo courseFrontVo) {
        Page<EduCourse> pageCourse = new Page<>(page, limit);
        Map<String, Object> map = courseService.getCourseFrontList(pageCourse, courseFrontVo);
        // 返回分页所有数据
        return R.ok().data(map);
    }

    // 根据课程id查询课程信息
    @GetMapping("/getFrontCourseInfo/{courseId}")
    public R getFrontCourseInfo(@PathVariable String courseId, HttpServletRequest request) {
        // 根据课程id，编写sql语句查询课程信息
        CourseWebVo courseWebVo = courseService.getBaseCourseInfo(courseId);

        // 根据课程id查询章节和小节
        List<ChapterVo> chapterVideoList = chapterService.getChapterVideoByCourseId(courseId);

        // 根据课程id和用户id查询当前课程是否已经支付过了
        String userId = JwtUtils.getMemberIdByJwtToken(request);
        boolean buyCourse = ordersClient.isBuyCourse(courseId, userId);

        return R.ok().data("courseWebVo", courseWebVo).data("chapterVideoList", chapterVideoList).data("isBuy", buyCourse);
    }

//     根据课程id查询课程信息 --订单
    @PostMapping("/getCourseInfoOrder/{courseId}")
    public CourseWebVoOrder courseWebVoOrder(@PathVariable String courseId) {
        CourseWebVo courseWebVo = courseService.getBaseCourseInfo(courseId);
        CourseWebVoOrder courseWebVoOrder = new CourseWebVoOrder();
        BeanUtils.copyProperties(courseWebVo, courseWebVoOrder);
        return courseWebVoOrder;
    }

    // 根据课程名查询课程（模糊查询）
    @GetMapping("/getCourseByNameVague/{title}")
    public R getCourseByNameVague(@PathVariable String title) {
        List<EduCourse> list = courseService.getCourseByNameVague(title);
        System.out.println("title:" + title + "/list:" + list);
        return R.ok().data("courseList", list);
    }

}
