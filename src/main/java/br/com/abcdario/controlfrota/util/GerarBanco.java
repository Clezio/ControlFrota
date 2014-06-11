package br.com.abcdario.controlfrota.util;

import java.io.IOException;

import org.hibernate.MappingException;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.util.ClassUtils;

public class GerarBanco {
	private static final String RESOURCE_PATTERN = "**/*.class";

	public static void main(String[] args) {
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		scanPackages(cfg, "br.com.abcdario.controlfrota.modelo");
		cfg.configure();
		SchemaExport se = new SchemaExport(cfg);
		se.setOutputFile("C:/Users/Clezio/workspace/ControlFrota/docs/AutoEscolaPostgres.sql");
		se.create(true, true);
	}

	protected static void scanPackages(AnnotationConfiguration config, String packagesToScan) {
		PathMatchingResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
		if (packagesToScan != null) {
			try {

				String pattern = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX
						+ ClassUtils.convertClassNameToResourcePath(packagesToScan) + RESOURCE_PATTERN;
				Resource[] resources = resourcePatternResolver.getResources(pattern);
				MetadataReaderFactory readerFactory = new CachingMetadataReaderFactory(resourcePatternResolver);
				for (Resource resource : resources) {
					if (resource.isReadable()) {
						MetadataReader reader = readerFactory.getMetadataReader(resource);
						String className = reader.getClassMetadata().getClassName();

						config.addAnnotatedClass(resourcePatternResolver.getClassLoader().loadClass(className));

					}
				}

			} catch (IOException ex) {
				throw new MappingException("Failed to scan classpath for unlisted classes", ex);
			} catch (ClassNotFoundException ex) {
				throw new MappingException("Failed to load annotated classes from classpath", ex);
			}
		}
	}
}
