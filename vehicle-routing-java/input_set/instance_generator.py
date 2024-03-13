import json
import random


def generate_distance_matrix(size):
    matrix = [[0 for _ in range(size)] for _ in range(size)]
    for i in range(size):
        for j in range(i + 1, size):
            distance = random.randint(100, 1500)
            matrix[i][j] = distance
            matrix[j][i] = distance
    return matrix


def generate_input_file(filename, matrix_size, num_vehicles, depot):
    data = {
        "distance_matrix": generate_distance_matrix(matrix_size),
        "num_vehicles": num_vehicles,
        "depot": depot,
    }
    with open(filename, "w") as f:
        json.dump(data, f, indent=2)


# Generate a file with a random matrix size between 15 and 20,
# a random number of vehicles between 4 and 10, and depot 0
for i in range(1, 8):
    generate_input_file(f"{i}.json", random.randint(15, 20), random.randint(4, 10), 0)
