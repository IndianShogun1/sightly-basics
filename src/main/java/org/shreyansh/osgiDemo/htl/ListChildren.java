package org.shreyansh.osgiDemo.htl;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.scripting.SlingScriptHelper;
import org.apache.sling.scripting.sightly.pojo.Use;
import org.osgi.service.component.annotations.Reference;


import javax.script.Bindings;
import java.util.Iterator;
import java.util.List;

public class ListChildren  implements Use{

//    @Reference
//    SomeService someService;

//    Iterator<Resource> children = null;
    List<Resource> children = null;

    String path;

    @Override
    public void init(Bindings bindings) {
        SlingHttpServletRequest request = (SlingHttpServletRequest) bindings.get("request");
        path = request.getParameter("path");
//        Resource resource = request.getResourceResolver().getResource(path);
//        children = resource.listChildren();
        SlingScriptHelper slingScriptHelper = (SlingScriptHelper) bindings.get("sling");
        SomeService someService = slingScriptHelper.getService(SomeService.class);
        children = someService.listChildren(path);
//        int count = 0;
//        while(children.hasNext()) {
//            count++;
//            children.next();
//        }
//        System.out.println(count);
    }

    public List<Resource> getChildren() {
//        int count = 0;
//        while(children.hasNext()) {
//            count++;
//            children.next();
//        }
//        System.out.println(count);
//        while (children.hasNext()) {
//            Resource resource = children.next();
//            ValueMap valueMap = resource.adaptTo(ValueMap.class);
//            System.out.println(valueMap.get("title", "default"));
//        }
//        System.out.println(children);
        return children;
    }
}
