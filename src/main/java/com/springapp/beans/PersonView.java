package com.springapp.beans;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created with IntelliJ IDEA.
 * User: akol
 * Date: 7/2/13
 * Time: 11:47 AM
 * To change this template use File | Settings | File Templates.
 */
@XmlRootElement
public class PersonView {
  private String id;
  private String name;
  private String age;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }


}
