package com.springboot.shirotest.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.text.TextConfigurationRealm;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author amc2533064395@163.com
 * @date 2019/6/9 22:08
 */
@Configuration
public class ShiroConfig {
    /**
     * 自定义realm
     * @return
     */
    @Bean
    public Realm realm(){
        TextConfigurationRealm realm=new TextConfigurationRealm();
        realm.setUserDefinitions("sang=123,user\n admin=123,admin");
        realm.setRoleDefinitions("admin=read,write\n user=read");
        return realm;

    }


    @Bean
    public ShiroFilterChainDefinition shiroFilterChainDefinition(){
        DefaultShiroFilterChainDefinition defaultShiroFilterChainDefinition=new DefaultShiroFilterChainDefinition();
        defaultShiroFilterChainDefinition.addPathDefinition("/login","anon");
        defaultShiroFilterChainDefinition.addPathDefinition("/doLogin","anon");
        defaultShiroFilterChainDefinition.addPathDefinition("/logout","logout");
        defaultShiroFilterChainDefinition.addPathDefinition("/**","authc");
        return  defaultShiroFilterChainDefinition;

    }

    /**
     * 为了支持在thymeleaf使用shiro标签
     * @return
     */
    @Bean
    public ShiroDialect shiroDialect(){
        return  new ShiroDialect();
    }

}
