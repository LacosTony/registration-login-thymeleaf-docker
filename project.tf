provider "docker"{
	host = "tcp://127.0.0.1:2375"
}

resource "docker_image" "thymeleaf_project"{
	name = "thymeleaf_project"
}

resource "docker_container" "thymeleaf_project"{
	name = "thymeleaf_project"
	image = "${docker_image.thymeleaf_project.latest}"
	must_run = true
	ports{
		internal = 8080
		external = 8080
	}
}