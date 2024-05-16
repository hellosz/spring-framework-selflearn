package com.ralph.service;

import com.ralph.domain.pojo.AnnotationBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: BeanService
 * @description:
 * @author: Neng.Tian
 * @create: 2024-04-17 09:35
 **/
@Service
public class BeanService {

    private AnnotationBean annotationBean;

    @Autowired
    public void setAnnotationBean(AnnotationBean annotationBean) {
        this.annotationBean = annotationBean;
    }

    public AnnotationBean getAnnotationBean() {
        return annotationBean;
    }
}
