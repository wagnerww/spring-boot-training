package br.com.wagnerww.springBoot.converter;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

import java.util.ArrayList;
import java.util.List;

public class DozerConverter {
    private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();

    public static <O, D> D paseObject(O origin, Class<D> destination){
        return mapper.map(origin, destination);
    }

    public static <O, D> List<D> paseListObjects(List<O> origin, Class<D> destination){
        List<D> destinatiationObject = new ArrayList<D>();
        for (Object o : origin) {
            destinatiationObject.add(mapper.map(o, destination));
        }

        return destinatiationObject;
    }
}
