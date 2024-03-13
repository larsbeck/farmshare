package com.nextmv.example;

public class Options {
  private final String inputPath;
  private final String outputPath;
  private final int duration;
  private final int unplannedPenalty;
  private final int maxTravelDuration;

  public Options(String inputPath, String outputPath, int duration, int unplannedPenalty, int maxTravelDuration) {
    this.inputPath = inputPath;
    this.outputPath = outputPath;
    this.duration = duration;
    this.unplannedPenalty = unplannedPenalty;
    this.maxTravelDuration = maxTravelDuration;
  }

  public String getInputPath() {
    return this.inputPath;
  }

  public String getOutputPath() {
    return this.outputPath;
  }

  public int getDuration() {
    return this.duration;
  }

  public int getUnplannedPenalty() {
    return this.unplannedPenalty;
  }

  public int getMaxTravelDuration() {
    return this.maxTravelDuration;
  }

  public static Options fromArguments(String[] args) {
    String inputPath = "";
    String outputPath = "";
    int duration = 30;
    // set maxTravelDuration to max int
    int maxTravelDuration = Integer.MAX_VALUE;
    // set unplannedPenalty to max int
    int unplannedPenalty = Integer.MAX_VALUE;

    for (int i = 0; i < args.length; ++i) {
      String[] parts = args[i].split("=", 2);
      String arg = parts[0];
      String value = parts.length > 1 ? parts[1] : null;
  
      switch (arg) {
          case "-i":
          case "-input":
              inputPath = value != null ? value : args[++i];
              break;
          case "-o":
          case "-output":
              outputPath = value != null ? value : args[++i];
              break;
          case "-d":
          case "-duration":
              duration = Integer.parseInt(value != null ? value : args[++i]);
              break;
          case "-td":
          case "-max.travel.duration":
              maxTravelDuration = Integer.parseInt(value != null ? value : args[++i]);
              break;
          case "-p":
          case "-unplanned.penalty":
              unplannedPenalty = Integer.parseInt(value != null ? value : args[++i]);
              break;
          case "-h":
          case "-help":
              System.out.println("Usage: java -jar basic_example.jar [OPTIONS]");
              System.out.println("Solve a simple linear program.");
              System.out.println();
              System.out.println("Supported options:");
              System.out.println("  -i, -input: path to the input file");
              System.out.println("  -o, -output: path to the output file");
              System.out.println("  -d, -duration: duration of the search in seconds");
              System.out.println("  -td, -max.travel.duration: maximum travel duration");
              System.out.println("  -p, -unplanned.penalty: penalty for unplanned nodes");
              System.out.println("  -h, -help: print the help");
              System.exit(0);
              break;
          default:
              if (!arg.startsWith("-")) {
                  System.err.println("Unknown argument: '" + arg + "'");
                  System.exit(1);
              }
      }
  }

    return new Options(inputPath, outputPath, duration, unplannedPenalty, maxTravelDuration);
  }
}
