package org.hl7.fhir.r5.utilities;

import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent;

public class StructuralMatch<T> {

  private T left;
  private T right; 
  private String error;
  private List<StructuralMatch<T>> children = new ArrayList<>();
  
  public StructuralMatch() {
    // root, just a place holder...
  }
  
  public StructuralMatch(T left, T right) {
    super();
    this.left = left;
    this.right = right;
  }
  
  public StructuralMatch(T left, T right, String error) {
    super();
    this.left = left;
    this.right = right;
    this.error = error;
  }
  
  public StructuralMatch(String error, T right) {
    super();
    this.error = error;
    this.right = right;
  }

  public StructuralMatch(T left, String error) {
    super();
    this.left = left;
    this.error = error;
  }
    
  public T getLeft() {
    return left;
  }
  public T getRight() {
    return right;
  }
  public String getError() {
    return error;
  }

  public List<StructuralMatch<T>> getChildren() {
    return children;
  }

  /**
   * return left if it exists, or return right (which might be null)
   * 
   * This is used when accessing whatever makes the items common
   * 
   * @return
   */
  public T either() {
    return left != null ? left : right;
  }

  public boolean hasLeft() {
    return left != null;
  }
  
  public boolean hasRight() {
    return right != null;
  }
  
}