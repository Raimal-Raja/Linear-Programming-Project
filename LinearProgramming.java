import java.util.*;

public class LinearProgramming {
    private double[] objectiveCoefficients;
    private double[][] constraintCoefficients;
    private double[] constraintBounds;
    private int numVariables;
    private int numConstraints;
    private double[] newObjectiveCoefficients;
    private double[][] newConstraintCoefficients;

    public LinearProgramming(double[] objectiveCoefficients, double[][] constraintCoefficients, double[] constraintBounds) {
        this.objectiveCoefficients = objectiveCoefficients;
        this.constraintCoefficients = constraintCoefficients;
        this.constraintBounds = constraintBounds;
        this.numVariables = constraintCoefficients[0].length - 1; // Update numVariables calculation
        this.numConstraints = constraintCoefficients.length;
    }

    public void convertToStandardForm() {
        int numSlackVariables = countSlackVariables();
        initializeNewCoefficients(numSlackVariables);
        addSlackVariables(numSlackVariables);
    }

    private int countSlackVariables() {
        int numSlackVariables = 0;
        for (int i = 0; i < numConstraints; i++) {
            double constraintSum = 0;
            for (int j = 0; j < numVariables; j++) {
                constraintSum += constraintCoefficients[i][j];
            }
            if (constraintSum > constraintBounds[i]) {
                numSlackVariables++;
            } else if (constraintSum < constraintBounds[i]) {
                numSlackVariables++;
            }
        }
        return numSlackVariables;
    }

    private void initializeNewCoefficients(int numSlackVariables) {
        newObjectiveCoefficients = Arrays.copyOf(objectiveCoefficients, objectiveCoefficients.length + numSlackVariables);
        Arrays.fill(newObjectiveCoefficients, objectiveCoefficients.length, newObjectiveCoefficients.length, 0);
        newConstraintCoefficients = new double[numConstraints][numVariables + numSlackVariables];
    }

    private void addSlackVariables(int numSlackVariables) {
        int slackIndex = numVariables;
        for (int i = 0; i < numConstraints; i++) {
            double constraintSum = 0;
            for (int j = 0; j < numVariables; j++) {
                newConstraintCoefficients[i][j] = constraintCoefficients[i][j];
                constraintSum += constraintCoefficients[i][j];
            }
            if (constraintSum > constraintBounds[i]) {
                newConstraintCoefficients[i][slackIndex] = 1;
                slackIndex++;
            } else if (constraintSum < constraintBounds[i]) {
                newConstraintCoefficients[i][slackIndex] = -1;
                slackIndex++;
            }
        }
    }

    public double[] getNewObjectiveCoefficients() {
        return newObjectiveCoefficients;
    }

    public double[][] getNewConstraintCoefficients() {
        return newConstraintCoefficients;
    }

    public double[] getConstraintBounds() {
        return constraintBounds;
    }

    public static void main(String[] args) {
        double[] objectiveCoefficients = {3, 4};
        double[][] constraintCoefficients = {
            {1, 2, 10},
            {2, 1, 8},
            {1, -1, 2}
        };
        double[] constraintBounds = {10, 8, 2};

        LinearProgramming lp = new LinearProgramming(objectiveCoefficients, constraintCoefficients, constraintBounds);
        lp.convertToStandardForm();

        double[] newObjectiveCoefficients = lp.getNewObjectiveCoefficients();
        double[][] newConstraintCoefficients = lp.getNewConstraintCoefficients();

        System.out.println("New Objective Coefficients: " + Arrays.toString(newObjectiveCoefficients));
        System.out.println("New Constraint Coefficients:");
        for (double[] row : newConstraintCoefficients) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("Constraint Bounds: " + Arrays.toString(constraintBounds));
    }
}