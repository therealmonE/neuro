package io.github.therealmone.matrix.model;

public class MatrixData {
  private final Double matrix [][];

  MatrixData (int row, int column){
    this.matrix = new Double[row][column];
  }

  MatrixData (int row){
    this.matrix = new Double[row][1];
  }

  void setValue (int row, int column, Double value){
    matrix[row][column] = value;
  }
  void setValue (int row, Double value){ matrix[row][0] = value;}

  Double getValue (int row, int column){
    return matrix[row][column];
  }
  Double getValue (int row){
    return matrix[row][0];
  }

  int getRow(){
    return matrix.length;
  }
  int getColumn(){
    return matrix[0].length;
  }
}
