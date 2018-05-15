package com.magaofei.qa.web;

import com.magaofei.qa.dao.RequestResponseLog;
import com.magaofei.qa.mapper.RequestResponseLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/requestLog/{id}")
public class TestController {

    @Autowired
    private RequestResponseLogMapper requestResponseLogMapper;

    @RequestMapping(method = RequestMethod.GET)
    private RequestResponseLog requestLog (@PathVariable Integer id) {
        return requestResponseLogMapper.findById(id);
    }

}
