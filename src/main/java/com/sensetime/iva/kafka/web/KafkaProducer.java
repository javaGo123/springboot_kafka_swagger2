package com.sensetime.iva.kafka.web;

import com.sensetime.iva.kafka.producer.Sender;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class KafkaProducer {

  @Autowired
  Sender sender;

  @ApiOperation(value="发送数据", notes="发送kafka数据")
  @ApiImplicitParam(name = "data", value = "发送给kafka的数据", required = true, dataType = "String")
  @RequestMapping(value = "/sendTest", method = RequestMethod.POST)
  public void exec(@RequestBody String data, HttpServletResponse response) throws IOException{
    this.sender.send("testtopic",data);
    response.setCharacterEncoding("UTF-8");
    response.setContentType("text/json");
    response.getWriter().write("success");
    response.getWriter().flush();
    response.getWriter().close();
  }

}
