package edu.grinnell.csc207.util;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test suite for MatrixV0<T>.
 *
 * @author Slok Rajbhandari
 */
public class TestsByStudent {

  /**
   * Test the constructor for proper initialization and size.
   */
  @Test
  public void testMatrixConstructor() {
    MatrixV0<String> matrix = new MatrixV0<>(3, 4, "default");
    assertEquals(3, matrix.width(), "Matrix should have correct width.");
    assertEquals(4, matrix.height(), "Matrix should have correct height.");
    assertEquals("default", matrix.get(0, 0), "Matrix should initialize with the default value.");
  }

  /**
   * Test the set and get methods for proper functionality.
   */
  @Test
  public void testSetGet() {
    MatrixV0<Integer> matrix = new MatrixV0<>(3, 3, 0);
    matrix.set(1, 1, 5);
    assertEquals(5, matrix.get(1, 1), "Set and Get should work correctly.");
    matrix.set(0, 0, 10);
    assertEquals(10, matrix.get(0, 0), "Set and Get should work for multiple values.");
  }

  /**
   * Test the insertRow method.
   */
  @Test
  public void testInsertRow() throws ArraySizeException {
    MatrixV0<Integer> matrix = new MatrixV0<>(3, 3, 0);
    matrix.insertRow(1, new Integer[] {4, 4, 4});
    assertEquals(4, matrix.get(1, 0), "Inserted row should have correct values.");
    assertEquals(4, matrix.get(1, 1), "Inserted row should have correct values.");
    assertEquals(4, matrix.get(1, 2), "Inserted row should have correct values.");
  }

  /**
   * Test the insertCol method.
   */
  @Test
  public void testInsertCol() throws ArraySizeException{
    MatrixV0<Integer> matrix = new MatrixV0<>(3, 3, 0);
    matrix.insertCol(1, new Integer[] {4, 4, 4});
    assertEquals(4, matrix.get(0, 1), "Inserted column should have correct values.");
    assertEquals(4, matrix.get(1, 1), "Inserted column should have correct values.");
    assertEquals(4, matrix.get(2, 1), "Inserted column should have correct values.");
  }

  /**
   * Test deletion of a row.
   */
  @Test
  public void testDeleteRow() {
    MatrixV0<Integer> matrix = new MatrixV0<>(3, 4, 0);
    matrix.set(1, 1, 2); // Add value to check later
    matrix.deleteRow(1);
    assertEquals(3, matrix.height(), "Height should decrease after deleting a row.");
    assertNotEquals(2, matrix.get(1, 1), "Deleted row's data should be removed.");
  }

  /**
   * Test deletion of a column.
   */
  @Test
  public void testDeleteCol() {
    MatrixV0<Integer> matrix = new MatrixV0<>(3, 3, 0);
    matrix.set(1, 1, 3); // Add value to check later
    matrix.deleteCol(1);
    assertEquals(2, matrix.width(), "Width should decrease after deleting a column.");
    assertNotEquals(3, matrix.get(1, 1), "Deleted column's data should be removed.");
  }

  /**
   * Test fillRegion method.
   */
  @Test
  public void testFillRegion() {
    MatrixV0<String> matrix = new MatrixV0<>(4, 4, "default");
    matrix.fillRegion(1, 1, 3, 3, "filled");
    assertEquals("filled", matrix.get(1, 1), "The region should be filled correctly.");
    assertEquals("filled", matrix.get(2, 2), "The region should be filled correctly.");
    assertEquals("default", matrix.get(3, 3), "Outside the region should remain unchanged.");
  }

  /**
   * Test fillLine method.
   */
  @Test
  public void testFillLine() {
    MatrixV0<Integer> matrix = new MatrixV0<>(5, 5, 0);
    matrix.fillLine(0, 0, 1, 1, 5, 5, 9);
    assertEquals(9, matrix.get(0, 0), "The first element of the diagonal should be filled.");
    assertEquals(9, matrix.get(1, 1), "The second element of the diagonal should be filled.");
    assertEquals(9, matrix.get(4, 4), "The last element of the diagonal should be filled.");
  }

  /**
   * Test clone method.
   */
  @Test
  public void testClone() {
    MatrixV0<String> matrix = new MatrixV0<>(3, 3, "default");
    matrix.set(1, 1, "cloned");
    MatrixV0<String> clone = (MatrixV0<String>) matrix.clone();
    assertEquals(matrix.get(1, 1), clone.get(1, 1), "Cloned matrix should have the same values.");
    assertEquals(matrix.width(), clone.width(), "Cloned matrix should have the same width.");
    assertEquals(matrix.height(), clone.height(), "Cloned matrix should have the same height.");
  }

  /**
   * Test equals method.
   */
  @Test
  public void testEquals() {
    MatrixV0<String> matrix1 = new MatrixV0<>(3, 3, "default");
    MatrixV0<String> matrix2 = new MatrixV0<>(3, 3, "default");
    assertTrue(matrix1.equals(matrix2), "Matrices with the same values should be equal.");
    matrix2.set(1, 1, "different");
    assertFalse(matrix1.equals(matrix2), "Matrices with different values should not be equal.");
  }
}

