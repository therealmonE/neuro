package io.github.therealmone.matrix.model;

import io.github.therealmone.matrix.Matrix;

public class MatrixImpl implements Matrix {
  private final MatrixData neurons;
  private final MatrixData weights;

  public MatrixImpl (MatrixData neurons, MatrixData weights){
    this.neurons = neurons;
    this.weights = weights;
  }

  @Override
  public MatrixData weightResultMatrix (){
    MatrixData result = new MatrixData(weights.getRow(), neurons.getColumn());

    if (weights.getColumn() != neurons.getRow()){
      System.out.println("Error");
      return result;
    }

    for (int i = 0; i < weights.getRow(); i++){
      Double value = 0.0;
      for (int j = 0; j < weights.getColumn(); j++){
        value += ( weights.getValue(i, j) * neurons.getValue(j) );
      }
      result.setValue(i, value);
    }
    return result;
  }
}
