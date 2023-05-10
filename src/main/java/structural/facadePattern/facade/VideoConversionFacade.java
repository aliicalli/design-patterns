package structural.facadePattern.facade;

import structural.facadePattern.AudioMixer;
import structural.facadePattern.BitrateReader;
import structural.facadePattern.Codec;
import structural.facadePattern.CodecFactory;
import structural.facadePattern.MPEG4CompressionCodec;
import structural.facadePattern.OggCompressionCodec;
import structural.facadePattern.VideoFile;

import java.io.File;

public class VideoConversionFacade {
    public File convertVideo(String fileName, String format) {
        System.out.println("VideoConversionFacade: conversion started.");
        VideoFile file = new VideoFile(fileName);
        Codec sourceCodec = CodecFactory.extract(file);
        Codec destinationCodec;
        if (format.equals("mp4")) {
            destinationCodec = new MPEG4CompressionCodec();
        } else {
            destinationCodec = new OggCompressionCodec();
        }
        VideoFile buffer = BitrateReader.read(file, sourceCodec);
        VideoFile intermediateResult = BitrateReader.convert(buffer, destinationCodec);
        File result = (new AudioMixer()).fix(intermediateResult);
        System.out.println("VideoConversionFacade: conversion completed.");
        return result;
    }
}