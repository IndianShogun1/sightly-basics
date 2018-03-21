package org.shreyansh.osgiDemo.htl;

import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Component;
import org.apache.sling.api.resource.Resource;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Reference;
//import org.shreyansh.osgiDemo.services.ClassConfiguration;

import java.util.*;


@Component( service = SomeService.class, immediate = true)
public class ListChildrenService implements SomeService {

    ResourceResolver resourceResolver = null;

    @Reference
    private ResourceResolverFactory resolverFactory;

    @Activate
    public void activate() {
        System.out.println("Calling Activate Method From List Children Service");
    }

    @Override
    public List<Resource> listChildren(String path) {
//        System.out.println("In method");
//        ResourceResolver resourceResolver = null;
//        Iterator<Resource> children = null;
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put(ResourceResolverFactory.SUBSERVICE, "SomeService");
//        try {
//            resourceResolver = resolverFactory.getServiceResourceResolver(map);
//            Resource resource = resourceResolver.getResource(path);
//            children = resource.listChildren();
//            int count = 0;
//            while(children.hasNext()) {
//                count++;
//                children.next();
//            }
//            System.out.println(count);
//            resourceResolver.close();
//            return children;
//        } catch (LoginException e) {
//            System.out.println("in catch");
//            e.printStackTrace();
//        }
//        int count = 0;
//        while(children.hasNext()) {
//            count++;
//            children.next();
//        }
//        System.out.println(count);
//
//        return children;

        List<Resource> childrenList = new ArrayList<>();
        try {


            Map<String, Object> param = new HashMap<String, Object>();
            param.put(ResourceResolverFactory.SUBSERVICE, "SomeService");

            resourceResolver = resolverFactory.getServiceResourceResolver(param);
            Resource res = resourceResolver.getResource(path);

            Iterator<Resource> resourceIterator = res.listChildren();

            while (resourceIterator.hasNext()) {
                childrenList.add(resourceIterator.next());

            }


            return childrenList;


        } catch (LoginException e) {
            e.printStackTrace();
        } //// finally {
//            resourceResolver.close();
//        }
        return childrenList;

    }
}
