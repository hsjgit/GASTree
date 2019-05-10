package com.hsj.config;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import javax.servlet.MultipartConfigElement;

/**
 * @author waja
 * Created by 黄仕杰 on 2019/4/13.
 */
@Configuration
public class MyConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/e").setViewName("adai/tpmo/contact");
        registry.addViewController("/h").setViewName("three/webgl_lightshafts");
        registry.addViewController("/in").setViewName("indexadai");
        registry.addViewController("/k").setViewName("three/webgl_animation_keyframes");//日漫
        registry.addViewController("/t").setViewName("three/webgl_geometry_terrain_raycast");//土
        registry.addViewController("/he").setViewName("three/webgl_lights_hemisphere");//火烈鸟
        registry.addViewController("/h").setViewName("h");//马
        registry.addViewController("/g").setViewName("gltf");
        registry.addViewController("/ed").setViewName("blog/edit");
        registry.addViewController("/pageindex").setViewName("determinePage/index");
        registry.addViewController("/home1").setViewName("three/homeone");
        registry.addViewController("/home2").setViewName("three/hometwo");
        registry.addViewController("/log").setViewName("login");//登录
        registry.addViewController("/donatebooks").setViewName("/user/unity");
        registry.addViewController("/book").setViewName("/user/theme");//捐书的页面
        registry.addViewController("/sky").setViewName("graph");//关系图
        registry.addViewController("/getbook").setViewName("user/blog");
        registry.addViewController("/jl").setViewName("user/o");
        registry.addViewController("/vide").setViewName("video");
        registry.addViewController("/loginPage").setViewName("signUp");//这个要留
        registry.addViewController("/diti").setViewName("ditu");
        registry.addViewController("/shu").setViewName("user/index");
        registry.addViewController("/hu").setViewName("huang");

    }

    //@Override
    //public void addCorsMappings(CorsRegistry registry) {
      //  registry.addMapping("/**");
    //}

    //@Override
    //public void addInterceptors(InterceptorRegistry registry) {
    //    registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
     //           .excludePathPatterns("/","/asserts/css/signin.css","/webjars/**","/user/loginPage","/fanqie.png","/user/loginUser","/static/**");
    //}

    //@Override
  //  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    //    registry.addResourceHandler("/static*//**").addResourceLocations("classpath:/static*//**");

   // }

    /**
     * <p>解决视频传输的问题<p/>
     * @return
     */
   @Bean
   public MultipartConfigElement multipartConfigElement() {
       MultipartConfigFactory factory = new MultipartConfigFactory();
       factory.setMaxFileSize("80MB");
       factory.setMaxRequestSize("102400KB");
       return factory.createMultipartConfig();
   }



}
