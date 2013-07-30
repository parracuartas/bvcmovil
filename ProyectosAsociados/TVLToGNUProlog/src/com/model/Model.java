package com.model;

import java.util.ArrayList;
import java.util.List;

/**
 * The starting non-terminal is the model, and quite naturally, a model is a
 * sequence of type, constant and feature declarations.
 * 
 * MODEL = ( TYPE | CONSTANT | FEATURE )*
 * 
 * @author Hans Parra, Juan Cuartas
 */
public abstract class Model {
    
    private List<Type> _types;
    private List<Constant> _constants;
    private List<Feature> _features;
    
    public Model() {
        _types = new ArrayList<>();
        _constants = new ArrayList<>();
        _features = new ArrayList<>();
    }
    
    public List<Type> getTypes() {
        return _types;
    }
    
    public List<Constant> getConstants() {
        return _constants;
    }
    
    public List<Feature> getFeatures() {
        return _features;
    }
    
    public void addType(Type type) {
        _types.add(type);
    }
    
    public void addConstant(Constant constant) {
        _constants.add(constant);
    }
    
    public void addFeature(Feature feature) {
        _features.add(feature);
    }
}